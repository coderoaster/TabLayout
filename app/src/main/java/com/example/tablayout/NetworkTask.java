package com.example.tablayout;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    Context context;
    String mAddr;
    ProgressDialog progressDialog;
    ArrayList<Student> members;

    Fragment fragment;

    public NetworkTask(Context context, String mAddr) {
        this.context = context;
        this.mAddr = mAddr;
        this.members = new ArrayList<Student>();
    }

    // ProgressDialog 설정 --------------------------------------------
    // 데이터를 받고있을때
    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialogue()");
        progressDialog.setMessage("down.....");
        progressDialog.show();
    }

    // 데이터가 바뀌엇을때
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

    }

    // 데이터가 완료되었을때
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
    // ProgressDialog 설정끝 --------------------------------------------

    @Override
    protected Object doInBackground(Integer... integers) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true) {
                    String strline = bufferedReader.readLine();
                    if (strline == null)
                        break;
                    stringBuffer.append(strline + "\n");
                }

                parser(stringBuffer.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) { bufferedReader.close(); }
                if (inputStreamReader != null) { inputStreamReader.close(); }
                if (inputStream != null) { inputStream.close(); }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return members;
    }

    protected void parser(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            members.clear();

            for (int i = 0 ; i < jsonArray.length() ; i++) {
                // JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

                String code = jsonObject1.getString("code");
                String name = jsonObject1.getString("name");
                String dept = jsonObject1.getString("dept");
                String phone = jsonObject1.getString("phone");

                Log.v("name : " , name);

                members.add(new Student(code, name, dept, phone));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
