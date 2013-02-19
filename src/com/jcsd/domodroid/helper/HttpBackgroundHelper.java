package com.jcsd.domodroid.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

class HttpBackgroundHelper extends AsyncTask<String, String, String> {

	public interface HttpBackgroundHelperHandler {
		public void onSuccess(String result);

		public void onException(Exception e);
	}

	HttpBackgroundHelperHandler handler;
	Exception e;

	public HttpBackgroundHelper(HttpBackgroundHelperHandler handler) {
		this.handler = handler;
	}

	@Override
	protected String doInBackground(String... uri) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response;
		String responseString = null;
		try {
			response = httpclient.execute(new HttpGet(uri[0]));
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				out.close();
				responseString = out.toString();
			} else {
				// Closes the connection.
				response.getEntity().getContent().close();
				throw new IOException(statusLine.getReasonPhrase());
			}
		} catch (ClientProtocolException e) {
			this.e = e;
		} catch (IOException e) {
			this.e = e;
		}
		return responseString;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (this.handler != null) {
			if (this.e != null) {
				this.handler.onException(e);
			} else {
				this.handler.onSuccess(result);
			}
		}

	}
}