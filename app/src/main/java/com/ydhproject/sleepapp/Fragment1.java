package com.ydhproject.sleepapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    PieChart pieChart;
    Button CameraButton;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate( R.layout.fragment_1, container, false );





        pieChart = (PieChart) view.findViewById(R.id.piechart  );
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef( 0.5f );
        pieChart.setHoleColor( Color.WHITE );
        pieChart.setTransparentCircleRadius( 24f );

        ArrayList<PieEntry> pieValue  = new ArrayList<PieEntry>();

        pieValue.add( new PieEntry( 15f/2,"꿈나라" ) );
        pieValue.add( new PieEntry( 33f/2,"" ) );

        Description description = new Description();
        description.setText( "단위 :0.5 = 30분" );
        description.setTextSize(9);
        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(pieValue," ");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors( ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextColor(Color.YELLOW);
        pieChart.setData(data);
        return view;
        //여기까지 그래프의 코드


    }


}