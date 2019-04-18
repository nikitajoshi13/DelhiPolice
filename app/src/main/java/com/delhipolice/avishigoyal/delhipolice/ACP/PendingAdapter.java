package com.delhipolice.avishigoyal.delhipolice.ACP;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.Database.UpdateStatus;
import com.delhipolice.avishigoyal.delhipolice.Police.OurData;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.List;


public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.MyHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    Context obj;
    int res;
    private List<OurData> listData;

    public PendingAdapter(Context obj, List listData) {
        this.obj = obj;
        this.listData = listData;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        //mlistener=listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(obj).inflate(R.layout.mylist, null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {
        myHolder.complaint.setText(listData.get(i).getComplaints());
        myHolder.location.setText(listData.get(i).getLocation());
        myHolder.trafficlight.setText(listData.get(i).getTraffic());
        myHolder.comment.setText(listData.get(i).getComments());
        myHolder.linearLayout.setVisibility(View.VISIBLE);
        myHolder.linearLayout1.setVisibility(View.VISIBLE);
        myHolder.callto.setVisibility(View.VISIBLE);
        myHolder.vendor.setText(listData.get(i).getVendor());
        myHolder.callto.setText("Call");

        PhoneCallListener phoneListener = new PhoneCallListener();
        TelephonyManager telephonyManager = (TelephonyManager) this.obj.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);



        myHolder.callto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*UpdateStatus updateStatus = new UpdateStatus(myHolder.complaint.getText().toString(),obj.getString(R.string.approve_payment),obj);
                updateStatus.execute();*/

                String phone="9716013005";
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String temp="tel:"+phone;
                callIntent.setData(Uri.parse(temp));
                if (ActivityCompat.checkSelfPermission(obj, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                obj.startActivity(callIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView complaint,location,trafficlight,comment,vendor;
        Button callto;
        LinearLayout linearLayout,linearLayout1;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            complaint=itemView.findViewById(R.id.complaintid);
            location=itemView.findViewById(R.id.locid);
            trafficlight=itemView.findViewById(R.id.traffid);
            comment=itemView.findViewById(R.id.commid);
            callto=itemView.findViewById(R.id.btnstat);
            vendor=itemView.findViewById(R.id.vendorid);
            linearLayout=itemView.findViewById(R.id.linearlay);
            linearLayout1=itemView.findViewById(R.id.linearlayout1);
           // linearLayout.invalidate();

        }
    }

    public class PhoneCallListener extends PhoneStateListener {

        private boolean isPhoneCalling = false;

        String LOG_TAG = "LOGGING 123";

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                // phone ringing
                Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
            }

            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
                // active
                Log.i(LOG_TAG, "OFFHOOK");

                isPhoneCalling = true;
            }

            if (TelephonyManager.CALL_STATE_IDLE == state) {
                // run when class initial and phone call ended,
                // need detect flag from CALL_STATE_OFFHOOK
                Log.i(LOG_TAG, "IDLE");

                if (isPhoneCalling) {

                    Log.i(LOG_TAG, "restart app");

                    // restart app
                    Intent i = obj.getPackageManager()
                            .getLaunchIntentForPackage(
                                    obj.getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    obj.startActivity(i);

                    isPhoneCalling = false;
                }

            }
        }
    }
}