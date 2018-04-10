package sunlearning.sunlearningdemo.study;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.CourseProjectEntity;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    private TabLayout studyTabLayout;
    private ViewPager studyViewPager;
    private TextView projectSelectorBtn;
    private TextView topTitleFlag;
    private TextView topTitleFlagInvert;
    private ImageView searchBtn;
    private Fragment[] sonFragments;
    private CourseProjectEntity curProject;
    private String tabNames[];

    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        studyTabLayout = view.findViewById(R.id.study_tab_layout);
        studyViewPager = view.findViewById(R.id.study_view_pager);
        projectSelectorBtn = view.findViewById(R.id.study_top_menu_project_selector);
        searchBtn = view.findViewById(R.id.study_top_menu_search);
        topTitleFlag=view.findViewById(R.id.top_examine_flag);
        topTitleFlagInvert=view.findViewById(R.id.top_examine_flag_invert);

        initData();
        initWidget();
        initEvents();

        return view;

    }

    private void initData() {
        tabNames = new String[]{"在学", "必修", "推荐", "公开课"};
        sonFragments = initFragments();
        curProject = InitDataUtil.getCourseProjectsData().get(0);
    }

    private void initWidget() {
        resetTopMenu(curProject);
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        //将viewPage绑定到tabLayout上
        studyTabLayout.setupWithViewPager(studyViewPager);
        //设置tab种文字正常颜色和选中后的颜色
        studyTabLayout.setTabTextColors(getResources().getColor(R.color.color_323232), getResources().getColor(R.color.color_46BC62));
        //设置选中的tab的下划线颜色
        studyTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_46BC62));
    }

    private void initViewPager() {
        //ViewPage设置适配器
        studyViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return sonFragments[position % sonFragments.length];
            }

            @Override
            public int getCount() {
                return sonFragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabNames[position % tabNames.length];
            }
        });
    }

    private void resetTopMenu(CourseProjectEntity curProject) {
        if (curProject != null) {
            projectSelectorBtn.setText(curProject.getName());
            topTitleFlagInvert.setVisibility(View.VISIBLE);
            topTitleFlag.setVisibility(View.GONE);
        } else {
            projectSelectorBtn.setText("暂无项目");
        }


    }


    //初始化事件
    private void initEvents() {
        projectSelectorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CourseProjectListActivity.class);
                intent.putExtra("curProject", curProject);
                startActivityForResult(intent, 0);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CourseSearchActivity.class));
            }
        });
    }

    private Fragment[] initFragments() {
        Fragment fragments[] = new Fragment[4];
        for (int i = 0; i < fragments.length; i++) {
            fragments[i] = new StudyCategoryFragment();
        }
        return fragments;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 0) {
            curProject= (CourseProjectEntity) data.getSerializableExtra("curProject");
            resetTopMenu(curProject);
        }
    }
}
