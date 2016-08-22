package airsponge.com.au.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import airsponge.com.au.entity.Address;
import airsponge.com.au.entity.Washer;
import airsponge.com.au.repository.AddressRepository;

@Service
@Transactional
public class AddressService {

	@Autowired
	private WasherService washerService;

	private final Geocoder geocoder = new Geocoder();

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Address findbyid(int id) {
		return addressRepository.findOne(id);
	}

	public void save(Address address) {
		addressRepository.save(address);

	}

	public String addressString(Address address) {
		return address.getAddressLine1().toString() + address.getSuburb() + address.getPostcode();
	}

	public GeocodeResponse getGeoResponse(String addressline1, String suburb, String postcode) {
		String addressString = addressline1 + suburb + postcode;
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(addressString).setLanguage("en")
				.getGeocoderRequest();
		GeocodeResponse geocoderResponse;
		try {
			geocoderResponse = geocoder.geocode(geocoderRequest);

			if (geocoderResponse.getStatus().value().equals("OK")) {
				return geocoderResponse;
			} else {
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}
	}

	public List<Washer> findNearbyWashers(Address address) {
		return findNearbyWashers(address, 5);
	}

	public List<Washer> findNearbyWashers(Address address, int howMany) {

		Double lat = address.getLatitude();
		Double lng = address.getLongitude();

		List<Washer> washers = washerService.findAll();
		List<Tuple<Washer, Double>> nearbyWashers = new ArrayList<Tuple<Washer, Double>>();

		for (Washer washer : washers) {

			Address washerAddress = washer.getUser().getAddress();
			Double washerLat = washerAddress.getLatitude();
			Double washerLng = washerAddress.getLongitude();

			if (washerLat != null && washerLng != null) {

				Double delta = distanceBetweenTwoLocations(lat, lng, washerLat, washerLng);
				Tuple<Washer, Double> tupleWasher = new Tuple<Washer, Double>(washer, delta);

				if (nearbyWashers.size() < howMany) {
					nearbyWashers.add(tupleWasher);

				} else {
					Comparator<Tuple<Washer, Double>> comparator = new Comparator<Tuple<Washer, Double>>() {
						@Override
						public int compare(Tuple<Washer, Double> o1, Tuple<Washer, Double> o2) {
							return o1.delta.compareTo(o2.delta);
						}
					};

					Tuple<Washer, Double> tupleMax = Collections.max(nearbyWashers, comparator);
					int index = nearbyWashers.indexOf(tupleMax);

					if (tupleMax.delta > delta) {
						nearbyWashers.remove(index);
						nearbyWashers.add(tupleWasher);
					}

				}
			}

		}

		washers = new ArrayList<Washer>();
		for (Tuple<Washer, Double> tuple : nearbyWashers) {
			washers.add(tuple.washer);
		}
		return washers;
	}

	private Double distanceBetweenTwoLocations(Double lat1, Double lng1, Double lat2, Double lng2) {
		Double earthRadius = 6372.8;
		Double deltaLat = deg2rad(lat2 - lat1);
		Double deltaLng = deg2rad(lng2 - lng1);
		Double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(deltaLng / 2) * Math.sin(deltaLng / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		Double distance = earthRadius * c;
		return distance;
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	public class Tuple<Washer, Double> {
		public final Washer washer;
		public final Double delta;

		public Tuple(Washer washer, Double delta) {
			this.washer = washer;
			this.delta = delta;
		}

	}

}
