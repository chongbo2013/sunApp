package sunlearning.sunlearningdemo.mine;


import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import sunlearning.sunlearningdemo.R;


public class MineFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tvPraise;
    private TextView mineDownloadTv;
    private TextView mineCollectTv;
    private TextView mineNotesTv;
    private TextView mineLiveTV;
    private LinearLayout mLinearLayout;
    private ImageView mineHeadImg;
    private LinearLayout mineShare;
    private LinearLayout mineinterpersonal;//我的人脉
    private LinearLayout minetrack;//成长轨迹
    private LinearLayout integral;//积分
    private LinearLayout mineset;//设置
    private LinearLayout minestudy;//学习记录
    private LinearLayout minetest;//考试记录
    private LinearLayout minetrain;//我的培训班
    private LinearLayout minelive;//我的直播
    private LinearLayout minelivein;//我参与的直播
    private LinearLayout mineincome;//收入情况
    private LinearLayout mineinfo;//个人中心


    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mine, container, false);
        tvPraise = view.findViewById(R.id.tv_praise_user);
        mineDownloadTv = view.findViewById(R.id.mine_download_tv);
        mineCollectTv = view.findViewById(R.id.mine_collect_tv);
        mineNotesTv = view.findViewById(R.id.mine_note_tv);
        mineLiveTV = view.findViewById(R.id.mine_live_tv);
        mLinearLayout = view.findViewById(R.id.mine_ll);
        mineHeadImg = view.findViewById(R.id.mine_head_img_civ);
        mineShare=view.findViewById(R.id.mine_share_ll);
        mineinterpersonal=view.findViewById(R.id.mine_interpersonal_ll);
        minetrack=view.findViewById(R.id.mine_track_ll);
        integral=view.findViewById(R.id.mine_integral_ll);
        mineset=view.findViewById(R.id.mine_set_ll);
        minestudy=view.findViewById(R.id.mine_study_ll);
        minetest=view.findViewById(R.id.mine_test_ll);
        minetrain=view.findViewById(R.id.mine_train_ll);
        minelive=view.findViewById(R.id.mine_live_ll);
        minelivein=view.findViewById(R.id.mine_livein_ll);
        mineincome=view.findViewById(R.id.mine_income_ll);
        mineinfo=view.findViewById(R.id.mine_info_ll);
        initData();
        initWidget();
        initEvent();
        return view;
    }

    private void initEvent() {
        tvPraise.setOnClickListener(this);
        mineDownloadTv.setOnClickListener(this);
        mineCollectTv.setOnClickListener(this);
        mineNotesTv.setOnClickListener(this);
        mineLiveTV.setOnClickListener(this);
        mineHeadImg.setOnClickListener(this);
        mineShare.setOnClickListener(this);
        mineinterpersonal.setOnClickListener(this);
        minetrack.setOnClickListener(this);
        integral.setOnClickListener(this);
        mineset.setOnClickListener(this);
        minestudy.setOnClickListener(this);
        minetest.setOnClickListener(this);
        minetrain.setOnClickListener(this);
        minelive.setOnClickListener(this);
        minelivein.setOnClickListener(this);
        mineincome.setOnClickListener(this);
        mineinfo.setOnClickListener(this);


    }

    private void initWidget() {
        initTVPraise();
        initNav();
        initMenu();
    }

    /**
     * 初始化底部菜单图标和文字
     */
    private void initMenu() {
        //获取资源配置的数据
        TypedArray ar = getResources().obtainTypedArray(R.array.mine_img_ll);
        //获取菜单左边的小图标对于的drawable值
        int drawableIds[] = new int[ar.length()];
        for (int i = 0; i < drawableIds.length; i++) {
            drawableIds[i] = ar.getResourceId(i, 0);
        }

        ar.recycle();
        //获取菜单项的名称
        String[] menuNames = getResources().getStringArray(R.array.mine_string_ll);
        //便利菜单linearlayout种的子元素
        int length = 0;
        for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
            View child = mLinearLayout.getChildAt(i);
            if (child instanceof LinearLayout) {
                LinearLayout tempLinearLayout = (LinearLayout) child;
                LinearLayout childView = (LinearLayout) tempLinearLayout.getChildAt(0);
                Drawable backgroundDrawable = getResources().getDrawable(drawableIds[length]);
                backgroundDrawable.setBounds(0, 0, 50, 50);
                TextView menuTv = (TextView) childView.getChildAt(0);
                menuTv.setText(menuNames[length]);
                menuTv.setCompoundDrawables(backgroundDrawable, null, null, null);
                length++;
            }
        }
    }

    /**
     * 重绘中部导航drawable
     */
    private void initNav() {
        Drawable drawables[] = new Drawable[]{
                mineDownloadTv.getCompoundDrawables()[1],
                mineCollectTv.getCompoundDrawables()[1],
                mineNotesTv.getCompoundDrawables()[1],
                mineLiveTV.getCompoundDrawables()[1]
        };

        TextView tvs[] = new TextView[]{
                mineDownloadTv, mineCollectTv, mineNotesTv, mineLiveTV
        };

        //重置大小
        for (Drawable drawable : drawables) {
            drawable.setBounds(0, 0, 66, 66);
        }

        for (int i = 0; i < tvs.length; i++) {
            TextView tv = tvs[i];
            tv.setCompoundDrawables(null, drawables[i], null, null);
        }
    }

    /**
     * 重绘点赞drawableLeft
     */
    private void initTVPraise() {
        Drawable zanDrawable = getResources().getDrawable(R.drawable.zan_white);
        zanDrawable.setBounds(0, 0, 31, 27);
        tvPraise.setCompoundDrawables(zanDrawable, null, null, null);
    }


    private void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_praise_user://赞列表
                showToast("点赞");
                break;
            case R.id.mine_head_img_civ: // 点击头像
                showToast("头像");
                break;
            case R.id.mine_download_tv: // 点击我的下载
                showToast("我的下载");
                break;
            case R.id.mine_collect_tv:  // 点击我的收藏
                showToast("我的收藏");
                break;
            case R.id.mine_note_tv: // 点击我的笔记
                showToast("我的笔记");
                break;
            case R.id.mine_share_ll:   // 点击我的分享记录
                showToast("分享记录");
                break;
            case R.id.mine_interpersonal_ll:  // 点击我的人脉
                showToast("我的人脉");
                break;
            case R.id.mine_track_ll:   // 点击成长轨迹
                showToast("成长轨迹");
                break;
            case R.id.mine_integral_ll: // 点击积分
                showToast("积分");
                break;
            case R.id.mine_set_ll:  // 点击设置
                showToast("设置");
                break;
            case R.id.mine_study_ll:  // 学习记录
                showToast("学习记录");
                break;
            case R.id.mine_test_ll:  // 考试记录
                showToast("考试记录");
                break;
            case R.id.mine_train_ll:  // 我的培训班
                showToast("我的培训班");
                break;
            case R.id.mine_live_ll://我的直播
                showToast("我的直播");
                break;
            case R.id.mine_livein_ll://我参与的直播
                showToast("我参与的直播");
                break;
            case R.id.mine_income_ll://收入情况
                showToast("收入情况");
                break;
            case R.id.mine_live_tv://开始直播
                showToast("我要直播");
                break;
            case R.id.mine_info_ll://个人中心
                showToast("个人中心");
                break;
        }
    }

    private void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
