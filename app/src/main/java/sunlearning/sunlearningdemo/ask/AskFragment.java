package sunlearning.sunlearningdemo.ask;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.utils.enums.AskType;

/**
 * A simple {@link Fragment} subclass.
 */
public class AskFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tabNames;
    private List<AskListFragment> fragments;


    public AskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ask, container, false);
        tabLayout = view.findViewById(R.id.ask_tab_layout);
        viewPager = view.findViewById(R.id.ask_view_pager);

        initData();
        initWidget();
        return view;
    }

    private void initWidget() {
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
        //设置tab的模式为滚动模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //设置tab种文字正常颜色和选中后的颜色
        tabLayout.setTabTextColors(getResources().getColor(R.color.color_323232),getResources().getColor(R.color.color_46BC62));
        //设置选中的tab的下划线颜色
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_46BC62));

    }

    private void initViewPager() {
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabNames[position];
            }
        });
    }

    private void initData() {
        //初始化标签名
        tabNames = AskType.getNames();
        //初始化fragment
        fragments = new ArrayList<>(tabNames.length);
        for(String tabName:tabNames){
            AskListFragment tempFragment=new AskListFragment();
            tempFragment.setAskType(AskType.getInstance(tabName));
            fragments.add(tempFragment);
        }
    }

}
