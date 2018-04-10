package sunlearning.sunlearningdemo.main;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maning.library.SwitcherView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

import sunlearning.common.listener.SmartRefreshLayoutCallbackListener;
import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.CourseEntity;
import sunlearning.sunlearningdemo.utils.imageLoader.GlideImageLoader;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    //顶部Banner
    private Banner banner;
    //顶部搜索栏
    private LinearLayout topBar;
    private TextView searchTv;
    //下拉刷新组件
    private SmartRefreshLayout refreshLayout;
    private Handler handler;
    //导航菜单按钮
    private Button classmatesBtn;
    private Button trainingBtn;
    private Button groupBtn;
    private Button mallBtn;
    private Button liveBtn;
    //跑马灯滚动字幕
    private SwitcherView switcherView;
    //最新课程
    private LinearLayout latestCourse;
    //最热课程
    private LinearLayout hotestCourse;
    private View viewHolder;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewHolder = inflater.inflate(R.layout.fragment_home, container, false);
        banner = viewHolder.findViewById(R.id.home_banner);
        topBar = viewHolder.findViewById(R.id.home_top_bar);
        refreshLayout = viewHolder.findViewById(R.id.home_refreshLayout);
        classmatesBtn = viewHolder.findViewById(R.id.home_classmates);
        trainingBtn = viewHolder.findViewById(R.id.home_training);
        groupBtn = viewHolder.findViewById(R.id.home_group);
        mallBtn = viewHolder.findViewById(R.id.home_mall);
        liveBtn = viewHolder.findViewById(R.id.home_live);
        searchTv = viewHolder.findViewById(R.id.tv_search_title);
        switcherView = viewHolder.findViewById(R.id.switcherView);
        latestCourse = viewHolder.findViewById(R.id.latestCourse);
        hotestCourse = viewHolder.findViewById(R.id.hotestCourse);

        initWidget();

        initData();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                msg.getCallback().run();
            }


        };

        return viewHolder;
    }

    private void initData() {
        //初始化最新课程
        initLatestCourse();
        //初始化最热课程
        initHotestCourse();
    }




    private void initWidget() {
        initBanner();
        //初始化下拉刷新组件
        initRefreshLayout();
        //初始化按钮
        initButton();
        //初始化搜索框图标
        initSearchDrawble();
        //初始化资讯跑马灯
        initSwicher();


    }

    private void initLatestCourse() {
        List<CourseEntity> courses = InitDataUtil.getLatestCourse();
        if (courses != null && courses.size() > 0) {
            CourseEntity course = courses.get(0);
            View courseView = latestCourse.findViewById(R.id.home_course_1);
            ImageView courseIcon = courseView.findViewById(R.id.home_course_icon_1);
            TextView zanTotal = courseView.findViewById(R.id.home_course_zan_total_1);
            TextView commentTotal = courseView.findViewById(R.id.home_course_comment_total_1);
            TextView courseName = courseView.findViewById(R.id.home_course_name_1);
            courseIcon.setImageDrawable(getResources().getDrawable(course.getImg()));
            zanTotal.setText(String.valueOf(course.getZanTotal()));
            commentTotal.setText(String.valueOf(course.getCommentTotal()));
            courseName.setText(course.getName());
            //设置第二门课程隐藏
            latestCourse.findViewById(R.id.home_course_2).setVisibility(View.INVISIBLE);
            if (courses.size() > 1) {
                course = courses.get(1);
                courseView = latestCourse.findViewById(R.id.home_course_2);
                courseIcon = courseView.findViewById(R.id.home_course_icon_2);
                zanTotal = courseView.findViewById(R.id.home_course_zan_total_2);
                commentTotal = courseView.findViewById(R.id.home_course_comment_total_2);
                courseName = courseView.findViewById(R.id.home_course_name_2);
                courseIcon.setImageDrawable(getResources().getDrawable(course.getImg()));
                zanTotal.setText(String.valueOf(course.getZanTotal()));
                commentTotal.setText(String.valueOf(course.getCommentTotal()));
                courseName.setText(course.getName());
                //第二门课程显示
                latestCourse.findViewById(R.id.home_course_2).setVisibility(View.VISIBLE);
            }

        }else{
            //隐藏课程
            latestCourse.findViewById(R.id.home_course_1).setVisibility(View.INVISIBLE);
            latestCourse.findViewById(R.id.home_course_2).setVisibility(View.INVISIBLE);
        }
    }

    private void initHotestCourse() {
        List<CourseEntity> courses = InitDataUtil.getHotestCourse();
        if (courses != null && courses.size() > 0) {
            CourseEntity course = courses.get(0);
            View courseView = hotestCourse.findViewById(R.id.home_course_1);
            ImageView courseIcon = courseView.findViewById(R.id.home_course_icon_1);
            TextView zanTotal = courseView.findViewById(R.id.home_course_zan_total_1);
            TextView commentTotal = courseView.findViewById(R.id.home_course_comment_total_1);
            TextView courseName = courseView.findViewById(R.id.home_course_name_1);
            courseIcon.setImageDrawable(getResources().getDrawable(course.getImg()));
            zanTotal.setText(String.valueOf(course.getZanTotal()));
            commentTotal.setText(String.valueOf(course.getCommentTotal()));
            courseName.setText(course.getName());
            //设置第二门课程隐藏
            hotestCourse.findViewById(R.id.home_course_2).setVisibility(View.INVISIBLE);
            if (courses.size() > 1) {
                course = courses.get(1);
                courseView = hotestCourse.findViewById(R.id.home_course_2);
                courseIcon = courseView.findViewById(R.id.home_course_icon_2);
                zanTotal = courseView.findViewById(R.id.home_course_zan_total_2);
                commentTotal = courseView.findViewById(R.id.home_course_comment_total_2);
                courseName = courseView.findViewById(R.id.home_course_name_2);
                courseIcon.setImageDrawable(getResources().getDrawable(course.getImg()));
                zanTotal.setText(String.valueOf(course.getZanTotal()));
                commentTotal.setText(String.valueOf(course.getCommentTotal()));
                courseName.setText(course.getName());
                //第二门课程显示
                hotestCourse.findViewById(R.id.home_course_2).setVisibility(View.VISIBLE);
            }

        }else{
            //隐藏课程
            hotestCourse.findViewById(R.id.home_course_1).setVisibility(View.INVISIBLE);
            hotestCourse.findViewById(R.id.home_course_2).setVisibility(View.INVISIBLE);
        }
    }
    

    private void initSwicher() {

        //设置数据源
        switcherView.setResource(InitDataUtil.getSwitcherData());
        //开始滚动
        switcherView.startRolling();

        //监听点击事件
        switcherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当前的展示的值
                Toast.makeText(getContext(), switcherView.getCurrentItem(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSearchDrawble() {
        Drawable[] compoundDrawables = searchTv.getCompoundDrawables();
        int height = searchTv.getHeight();
        for (Drawable drawable : compoundDrawables) {
            if (drawable != null) {
                drawable.setBounds(0, 0, 40, 40);
            }
        }
        searchTv.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    private void initButton() {
        Drawable classmatesDrawble = getResources().getDrawable(R.drawable.main_home_classmates);
        Drawable groupDrawble = getResources().getDrawable(R.drawable.main_home_group);
        Drawable trainingDrawble = getResources().getDrawable(R.drawable.main_home_training);
        Drawable mallDrawble = getResources().getDrawable(R.drawable.main_home_mall);
        Drawable liveDrawble = getResources().getDrawable(R.drawable.main_home_live);
        int width = 120;

        classmatesDrawble.setBounds(0, 0, width, width);
        groupDrawble.setBounds(0, 0, width, width);
        trainingDrawble.setBounds(0, 0, width, width);
        mallDrawble.setBounds(0, 0, width, width);
        liveDrawble.setBounds(0, 0, width, width);

        classmatesBtn.setCompoundDrawables(null, classmatesDrawble, null, null);
        trainingBtn.setCompoundDrawables(null, trainingDrawble, null, null);
        groupBtn.setCompoundDrawables(null, groupDrawble, null, null);
        mallBtn.setCompoundDrawables(null, mallDrawble, null, null);
        liveBtn.setCompoundDrawables(null, liveDrawble, null, null);

        classmatesBtn.setCompoundDrawablePadding(10);
        trainingBtn.setCompoundDrawablePadding(10);
        groupBtn.setCompoundDrawablePadding(10);
        mallBtn.setCompoundDrawablePadding(10);
        liveBtn.setCompoundDrawablePadding(10);
    }

    private void initRefreshLayout() {
        //设置上拉刷新监听器
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                refreshlayout.finishRefresh(0, true);//传入false表示刷新失败

            }
        });
        //关闭下拉加载功能
        refreshLayout.setEnableLoadMore(false);

        //设置refreshLayout的上拉刷新、回弹的回调函数
        refreshLayout.setCallbackListener(new SmartRefreshLayoutCallbackListener() {
            @Override
            public void preRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topBar.setVisibility(View.GONE);
                    }
                }, 0);
            }

            @Override
            public void afterFinish() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topBar.setVisibility(View.VISIBLE);
                    }
                }, 500);
            }
        });
    }

    private void initBanner() {

        //设置banner指样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片集合
        List<String> imagePaths = InitDataUtil.getPosterPaths();
        banner.setImages(imagePaths);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置banner图片的点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //销毁跑马灯
        switcherView.destroySwitcher();
    }
}
