package com.delhipolice.avishigoyal.delhipolice.Complains.OCR;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Database.RegisterComplaint;
import com.delhipolice.avishigoyal.delhipolice.R;
import com.google.android.gms.common.api.CommonStatusCodes;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * {@link ComplainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComplainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComplainFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private CompoundButton useFlash;
    private TextView statusMessage;
    private TextView textValue;
    Button register;
    Button readTextButton;
    private TextView d1;
    private TextView tvAddress;
    private Button btnShowAddress;
    AppLocationService appLocationService;
    Context thiscontext;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;


//    private Calendar calendar;
//    private SimpleDateFormat dateFormat;
//    private String date;

    private static final int RC_OCR_CAPTURE = 9003;
    private static final String TAG = "MainActivity";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ComplainFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static ComplainFragment newInstance(int param1) {
        ComplainFragment fragment = new ComplainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);



      }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_complain, container, false);



        statusMessage = (TextView)view.findViewById(R.id.status_message);
        textValue = (TextView)view.findViewById(R.id.text_value);
        useFlash = (CompoundButton) view.findViewById(R.id.use_flash);
            final TextView d1 = view.findViewById(R.id.Date);
        thiscontext = container.getContext();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        String currentDateandTime = sdf.format(new Date());
//        //TextView tv = (TextView) v.findViewById(R.id.textDate2);
//        d1.setText(currentDateandTime);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        //TextView textViewDate = findViewById(R.id.text_view_date);
        d1.setText(currentDate);

        tvAddress = (TextView) view.findViewById(R.id.location);
        appLocationService = new AppLocationService(thiscontext);

//        btnGPSShowLocation = (Button) findViewById(R.id.btnGPSShowLocation);
//        btnGPSShowLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Location gpsLocation = appLocationService
//                        .getLocation(LocationManager.GPS_PROVIDER);
//                if (gpsLocation != null) {
//                    double latitude = gpsLocation.getLatitude();
//                    double longitude = gpsLocation.getLongitude();
//                    String result = "Latitude: " + gpsLocation.getLatitude() +
//                            " Longitude: " + gpsLocation.getLongitude();
//                    tvAddress.setText(result);
//                } else {
//                    showSettingsAlert();
//                }
//            }
//        });

        final UUID uuid = UUID.randomUUID();

        register=view.findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //database
                //RegisterComplaint registerComplaint = new RegisterComplaint(uuid.toString(),tvAddress.getText().toString(),getString(R.string.new_status),d1.getText().toString(),getContext());
                //registerComplaint.execute();
                Toast.makeText(getContext(),"Complain lodged",Toast.LENGTH_SHORT).show();
            }
        });

        class GeocoderHandler extends Handler {
            @Override
            public void handleMessage(Message message) {
                String locationAddress;
                switch (message.what) {
                    case 1:
                        Bundle bundle = message.getData();
                        locationAddress = bundle.getString("address");
                        break;
                    default:
                        locationAddress = null;
                }
                tvAddress.setText(locationAddress);
            }
        }

        try {
            if (ActivityCompat.checkSelfPermission(getActivity(), mPermission)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(), new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       // tvAddress = view.findViewById(R.id.);
        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Location location = appLocationService.getLocation();

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
                //double latitude = 37.422005;
                //double longitude = -122.084095

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude, thiscontext, new GeocoderHandler());
                }
                else {
                    showAlert();
                }

            }
        });


//        gps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // launch Ocr capture activity.
//                this.locationResult = new LocationResult(){
//                    @Override
//                    public void gotLocation(Location location){
//
//                        //Got the location!
//                        if(location!=null){
//
//                            double latitude = location.getLatitude();
//                            double longitude = location.getLongitude();
//
//                            Log.e(TAG, "lat: " + latitude + ", long: " + longitude);
//
//                            // here you can save the latitude and longitude values
//                            // maybe in your text file or database
//
//                        }else{
//                            Log.e(TAG, "Location is null.");
//                        }
//
//                    }

//                };



                // to get location updates, initialize LocationResult

       // readTextButton = (Button) view.findViewById(R.id.read_text_button);
        textValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // launch Ocr capture activity.
                Intent intent = new Intent(getContext(), OcrCaptureActivity.class);
                intent.putExtra(OcrCaptureActivity.AutoFocus, true);
                intent.putExtra(OcrCaptureActivity.UseFlash, useFlash.isChecked());

                startActivityForResult(intent, RC_OCR_CAPTURE);
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RC_OCR_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                  //  readTextButton.setText("REGISTER COMPLAIN");
                    String text = data.getStringExtra(OcrCaptureActivity.TextBlockObject);
                    statusMessage.setText(R.string.ocr_success);
                    textValue.setText(text);
                    Log.d(TAG, "Text read: " + text);

                   // readTextButton.setOnClickListener(new View.OnClickListener() {
                      //  @Override
                       // public void onClick(View v) {
                         //   Intent i=new Intent(getContext(),LoggedComplain.class);
                           // startActivity(i);
                        //}
                    //});
                } else {
                    statusMessage.setText(R.string.ocr_failure);
                    Log.d(TAG, "No Text captured, intent data is null");
                }
            }
            else {
                statusMessage.setText(String.format(getString(R.string.ocr_error),
                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void showAlert()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(thiscontext);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        ComplainFragment.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }
}
