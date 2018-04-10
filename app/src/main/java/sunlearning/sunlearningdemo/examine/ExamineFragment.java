package sunlearning.sunlearningdemo.examine;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.ExamineProjectEntity;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamineFragment extends Fragment {
    private View view;
    private LinearLayout topSelector;
    private TextView topTitle;
    private TextView topTitleFlag;
    private TextView topTitleFlagInvert;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tabNames;
    private Fragment[] fragments;

    private ExamineProjectEntity curProject;
    private List<ExamineProjectEntity> projectList;

    public ExamineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_examine, container, false);
        topSelector=view.findViewById(R.id.examine_top_selector);
        topTitle = view.findViewById(R.id.top_examine_title);
        topTitleFlag=view.findViewById(R.id.top_examine_flag);
        topTitleFlagInvert=view.findViewById(R.id.top_examine_flag_invert);
        tabLayout=view.findViewById(R.id.examine_tab_layout);
        viewPager=view.findViewById(R.id.examine_view_pager);

        initWidget();
        initEvent();
        
        return view;
    }

    private void initEvent() {
        topSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExamineProjectListActivity.class);
                intent.putExtra("curProject",curProject);
                startActivityForResult(intent,0);
            }
        });
    }

    private void initWidget() {
        tabNames=new String[]{"考试","问卷调查"};
        fragments=new Fragment[]{new ExamineTestFragment(),new ExamineQuestionnaireFragment()};
        projectList=InitDataUtil.getExamineProjectsData();
        if(projectList!=null&&projectList.size()>0){
            curProject=projectList.get(0);
        }
        // TODO: 2018/4/8 空数据界面显示
        resetTopMenu(curProject);
        initViewPager();
        initTabLayout();
    }


    private void initViewPager() {
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabNames[position];
            }
        });
    }

    private void initTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
        //设置tab种文字正常颜色和选中后的颜色
        tabLayout.setTabTextColors(getResources().getColor(R.color.color_323232),getResources().getColor(R.color.color_46BC62));
        //设置选中的tab的下划线颜色
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_46BC62));
    }

    private void resetTopMenu(ExamineProjectEntity curProject) {
       if(curProject!=null){
           topTitle.setText(curProject.getName());
           topTitleFlagInvert.setVisibility(View.VISIBLE);
           topTitleFlag.setVisibility(View.GONE);
       }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0&&resultCode==0)
            curProject = (ExamineProjectEntity) data.getSerializableExtra("curProject");
            resetTopMenu(curProject);
    }
}
