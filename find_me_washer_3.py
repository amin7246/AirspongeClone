
# coding: utf-8

# In[1]:

import urllib
import json
import os
import csv
import math
from geopy.geocoders import Nominatim
from geopy.distance import vincenty
from geopy.exc import GeocoderTimedOut

googleGeocodeUrl = 'http://maps.googleapis.com/maps/api/geocode/json?'

def get_coordinates(query, from_sensor=False):
    '''
    returns:: latitute and longtitute of query
    query::address on Earth
    '''
    query = query.encode('utf-8')
    params = {
        'address': query,
        'sensor': "true" if from_sensor else "false"
    }
    url = googleGeocodeUrl + urllib.urlencode(params)
    json_response = urllib.urlopen(url)
    response = json.loads(json_response.read())
    if response['results']:
        location = response['results'][0]['geometry']['location']
        latitude, longitude = location['lat'], location['lng']
        #print query, latitude, longitude
    else:
        latitude, longitude = None, None
        #print query, "<no results>"
    return latitude, longitude


def write_to_csv(output_file, items_to_write):
    '''a function to write output in a new csv file
    output_file: path and name of new csv file
    items_to_write: list of items to write out
    returns nothing'''
    csvwrite = open(output_file, 'wb')
    writer = csv.writer(csvwrite, delimiter=",", quotechar=' ', quoting=csv.QUOTE_MINIMAL) 
    for item in items_to_write: 
        writer.writerow([item])

'''def distance_on_unit_sphere(lat1, long1, lat2, long2):
    """
    return::distance between two locations on Earth
    lat1::latitutde of address 1
    long1:longtitude of address 1
    lat2::latitutde of address 2
    long2:longtitude of address 2
    """
    # Convert latitude and longitude to 
    # spherical coordinates in radians.
    degrees_to_radians = math.pi/180.0
         
    # phi = 90 - latitude
    phi1 = (90.0 - lat1)*degrees_to_radians
    phi2 = (90.0 - lat2)*degrees_to_radians
         
    # theta = longitude
    theta1 = long1*degrees_to_radians
    theta2 = long2*degrees_to_radians
         
    # Compute spherical distance from spherical coordinates.
         
    # For two locations in spherical coordinates 
    # (1, theta, phi) and (1, theta', phi')
    # cosine( arc length ) = 
    #    sin phi sin phi' cos(theta-theta') + cos phi cos phi'
    # distance = rho * arc length
     
    cos = (math.sin(phi1)*math.sin(phi2)*math.cos(theta1 - theta2) + 
           math.cos(phi1)*math.cos(phi2))
    arc = math.acos( cos )
 
    # Remember to multiply arc by the radius of the earth 
    # in your favorite set of units to get length.
    #print("Distance is: ", arc*6371)
    return arc*6371'''

        
## This bit is information of the washee being queried for potential washer
washee_name = "zefteh"
washee_add = "coomera 4209,  Australia"
#washee_kit = "0"
washee_price = "50"
#washee_vacc = "1"
washee_phone = "xxxxxxxxx"

'''reading in the washer csv'''    
with open('/Users/Areej/Dropbox/airSponge/customers/washer/washer-report_10112015_edited_last_typeform_wordpress_22122015.csv', 'rU') as washers:
    washers_records = csv.reader(washers, delimiter=',', quotechar='|')
    
    headers = list(washers_records.next())
    avail1 = []
    avail2 = []
    postcodes = []
    travel_dist = []
    min_price = []
    washing_kit = []
    names = []
    phones = []
    emails = []
    sponge = []
    shampoo = []
    microfiber = []
    buckets = []
    cordless = []
    regular = []
        
    ## loop through the file to store washers values
    for row in washers_records:
        avail1.append(row[1])
        avail2.append(row[2])
        postcodes.append(row[3]+" QLD Australia")
        travel_dist.append(row[4])
        min_price.append(row[5])
        sponge.append(row[6])
        shampoo.append(row[7])
        microfiber.append(row[8])
        buckets.append(row[9])
        cordless.append(row[10])
        regular.append(row[11])        
        names.append(row[13])
        phones.append(row[15])
        emails.append(row[14])
        
    nearby_washers = []
    #washee_lon, washee_lat = get_coordinates(washee_add)
    washee_coord =  get_coordinates(washee_add)
    ## loop through washers lists
    nearby_washers.append("availability,other_days,distance_to_washee,name,postcode,phone,emails,sponge,shampoo,microfiber,buckets,cordless,regular")
    
    for i in range(len(postcodes)):
        #washer_lon, washer_lat =
        washer_coord =  get_coordinates(postcodes[i])
        #distance = distance_on_unit_sphere(washer_lat, washer_lon, washee_lat, washee_lon) 
        distance = vincenty(washer_coord, washee_coord).kilometers
        
        if distance < int(travel_dist[i]):
            if min_price[i] <= washee_price:
                nearby_washers.append(avail1[i] + "," + avail2[i] + "," + str(distance) + "," + names[i] + "," + postcodes[i] + "," + 
                                      phones[i] + "," + emails[i] + "," +  sponge[i] + "," + shampoo[i] + "," + microfiber[i] + "," + 
                                     buckets[i] + "," + cordless[i] + "," + regular[i])
                #print str(distance) + " " + postcodes[i] + " " + travel_dist[i] + " " + min_price[i]

    write_to_csv("/Users/Areej/Dropbox/airSponge/customers/script_output/potential_washers_for_" + washee_name + ".csv", nearby_washers)


# In[ ]:




# In[ ]:




# In[ ]:



