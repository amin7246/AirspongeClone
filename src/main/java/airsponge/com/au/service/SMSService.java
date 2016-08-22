package airsponge.com.au.service;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Service;

@Service
public class SMSService{
	
	

	public void SendTestSms(String number, String body) throws TwilioRestException {
	
		 // Find your Account Sid and Token at twilio.com/user/account
		  final String ACCOUNT_SID = "AC20a4b0010528206001d2ac305ef0f9f6";
		  final String AUTH_TOKEN = "9b6893f0de5a462ce3b65ac1d97276f5";
		 
		 
		    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		 
		    // Build a filter for the MessageList
		    List<NameValuePair> params = new ArrayList<NameValuePair>();
		    params.add(new BasicNameValuePair("Body", body));
		    params.add(new BasicNameValuePair("To", number));
		    params.add(new BasicNameValuePair("From", "+61427227304"));
		 
		    MessageFactory messageFactory = client.getAccount().getMessageFactory();
		    Message message = messageFactory.create(params);
		    System.out.println(message.getSid());
	
	}
	
	
}
