package com.delhipolice.avishigoyal.delhipolice.ACP;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.delhipolice.avishigoyal.delhipolice.ACP.OurData;
import com.delhipolice.avishigoyal.delhipolice.Police.PoliceStatusList;
import com.delhipolice.avishigoyal.delhipolice.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ACPButton.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ACPButton#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ACPButton extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Button b1,b2,b3;

    private OnFragmentInteractionListener mListener;

    public ACPButton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ACPButton.
     */
    // TODO: Rename and change types and number of parameters
    public static ACPButton newInstance(int param1) {
        ACPButton fragment = new ACPButton();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
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
        final View view= inflater.inflate(R.layout.fragment_acpbutton, container, false);
        final OurData lm=new OurData();
        b1=view.findViewById(R.id.approvepaymbutt);
        //tv1=view.findViewById(R.id.vendorid);
        b2=view.findViewById(R.id.pendingbutt);
        b3=view.findViewById(R.id.completebutt);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ACP.class);
                intent.putExtra("Button1","1");
                //intent.putExtra("Button",getString(R.string.approve_payment));
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),ACP.class);
                intent.putExtra("Button1","2");
                //intent.putExtra("Button",getString(R.string.pending_payment));
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),ACP.class);
                intent.putExtra("Button1","3");
                //intent.putExtra("Button",getString(R.string.completed));
                startActivity(intent);
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
}
