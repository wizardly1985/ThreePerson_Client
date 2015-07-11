package wizard.threeperson.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import android.R.string;
import android.os.AsyncTask;
import android.util.Log;

public class HttpUtils {
	static String result;

	public static String sendPostMessage(String path,String values) {
		System.out.println("doInBackground");
		
		new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... params) {
				try {
					Log.v("wiard_ly", params[0]);
					Log.v("wiard_ly", params[1]);
					URL url = new URL(params[0]);
					HttpURLConnection connection = (HttpURLConnection) url
							.openConnection();

					connection.setDoInput(true);
					connection.setDoOutput(true);
					connection.setRequestMethod("POST");

					OutputStreamWriter osw = new OutputStreamWriter(
							connection.getOutputStream(), "utf-8");
					BufferedWriter bw = new BufferedWriter(osw);
					bw.write(params[1]);
					bw.flush();

					InputStream is = connection.getInputStream();
					InputStreamReader isr = new InputStreamReader(is, "utf-8");
					BufferedReader br = new BufferedReader(isr);
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
						HttpUtils.this.result = line;
					}
					br.close();
					isr.close();
					is.close();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return HttpUtils.this.result;
			}

		}.execute(path,values);
		return null;


	}
}