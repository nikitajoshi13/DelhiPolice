package com.delhipolice.avishigoyal.delhipolice.Complains.vendor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//import com.delhipolice.avishigoyal.delhipolice.Police.OurData;
import com.delhipolice.avishigoyal.delhipolice.Police.PoliceStatusList;
import com.delhipolice.avishigoyal.delhipolice.Police.StatusButton;
import com.delhipolice.avishigoyal.delhipolice.R;

public class VendorFirst extends Fragment{

    /**
     * A simple {@link Fragment} subclass.
     * Activities that contain this fragment must implement the
     * {@link com.delhipolice.avishigoyal.delhipolice.Police.StatusButton.OnFragmentInteractionListener} interface
     * to handle interaction events.
     * Use the {@link com.delhipolice.avishigoyal.delhipolice.Police.StatusButton#newInstance} factory method to
     * create an instance of this fragment.
     */
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button b1,b2,b3;
    // TextView tv1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public VendorFirst() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
    //* @param param2 Parameter 2.
     * @return A new instance of fragment StatusButton.
     */
    // TODO: Rename and change types and number of parameters
    public static VendorFirst newInstance(int param1) {
        VendorFirst fragment = new VendorFirst();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.vendor_main, container, false);
        final OurData lm=new OurData();
        b1=view.findViewById(R.id.complains);
        //tv1=view.findViewById(R.id.vendorid);
        b2=view.findViewById(R.id.pendpay);
        b3=view.findViewById(R.id.completed);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),VendorStatus.class);
                intent.putExtra("Button","1");
                //intent.putExtra("Button",getString(R.string.pending));
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),VendorStatus.class);
                intent.putExtra("Button","2");
                //intent.putExtra("Button",getString(R.string.pending_payment));
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),VendorStatus.class);
                intent.putExtra("Button","3");
                //intent.putExtra("Button",getString(R.string.completed));
                startActivity(intent);
            }
        });
//            b4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getContext(),PoliceStatusList.class);
//                    intent.putExtra("Button","4");
//                    Log.d("button4","button 4");
//                    startActivity(intent);
//                }
//            });
//            b5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getContext(),PoliceStatusList.class);
//                    intent.putExtra("Button","5");
//                    startActivity(intent);
//                }
//            });
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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}


