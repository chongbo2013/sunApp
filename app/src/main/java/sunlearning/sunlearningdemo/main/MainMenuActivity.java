package sunlearning.sunlearningdemo.main;


import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.ask.AskFragment;
import sunlearning.sunlearningdemo.examine.ExamineFragment;
import sunlearning.sunlearningdemo.mine.MineFragment;
import sunlearning.sunlearningdemo.study.StudyFragment;

/**
 * Created by chenny on 2018/4/2.
 */

public class MainMenuActivity extends FragmentActivity {
    // fragmet视图
    private Fragment mFragment[];
    // fragment管理器
    private FragmentManager fragmentManager;
    // 菜单字符标识
    private String[] fragmentTags;
    // 记录底部RadioButton被选中的下标
    private int checkIndex = 0;
    // 记录当前选中的radioButton
    private RadioButton checkedRadioButton;


    private RadioGroup rgMainMenu;
    private RadioButton rbMainMenuHome;
    private RadioButton rbMainMenuStudy;
    private RadioButton rbMainMenuExamine;
    private RadioButton rbMainMenuAsk;
    private RadioButton rbMainMenuMine;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_main_menu);

        rgMainMenu=findViewById(R.id.rg_main_menu);
        rbMainMenuHome=findViewById(R.id.rg_main_menu_home);
        rbMainMenuStudy=findViewById(R.id.rg_main_menu_study);
        rbMainMenuExamine=findViewById(R.id.rg_main_menu_examine);
        rbMainMenuAsk=findViewById(R.id.rg_main_menu_ask);
        rbMainMenuMine=findViewById(R.id.rg_main_menu_mine);

        //初始化数据
        initData();
        //初始化控件
        initWidget();

    }

    private void initWidget() {
        //重置单选按钮的图片大小
        RadioButton buttons[]=new RadioButton[]{rbMainMenuHome,rbMainMenuStudy,rbMainMenuExamine,rbMainMenuAsk,rbMainMenuMine};
        for(RadioButton radioButton:buttons){
            Drawable drawable = radioButton.getCompoundDrawables()[1];
            drawable.setBounds(0,20,62,70);
            radioButton.setCompoundDrawables(null,drawable,null,null);
        }
        //设置单选按钮的选中事件
        rgMainMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //选中的fragment的下标
                int checkIndex=0;
                switch (checkedId){
                    case R.id.rg_main_menu_home:checkIndex=0;break;
                    case R.id.rg_main_menu_study:checkIndex=1;break;
                    case R.id.rg_main_menu_examine:checkIndex=2;break;
                    case R.id.rg_main_menu_ask:checkIndex=3;break;
                    case R.id.rg_main_menu_mine:checkIndex=4;break;
                }

                showFragment(checkIndex);
                //改变底栏菜单按钮颜色
                RadioButton curCheckedRadioButton = group.findViewById(checkedId);
               /* if(checkedRadioButton!=curCheckedRadioButton){
                    changeMenuRadioColor(curCheckedRadioButton,true);
                    changeMenuRadioColor(checkedRadioButton,false);
                }*/
                checkedRadioButton=curCheckedRadioButton;
            }
        });

    }

    private void changeMenuRadioColor(RadioButton curCheckedRadioButton, boolean isChecked) {
        if(isChecked){
            curCheckedRadioButton.setTextColor(getResources().getColor(R.color.red));
        }else{
            curCheckedRadioButton.setTextColor(getResources().getColor(R.color.black));
        }
    }

    private void initData() {
        checkedRadioButton=rbMainMenuHome;

        mFragment = new Fragment[]{
                new HomeFragment(),
                new StudyFragment(),
                new ExamineFragment(),
                new AskFragment(),
                new MineFragment()
        };

        fragmentTags = new String[]{
                HomeFragment.class.getSimpleName(),
                StudyFragment.class.getSimpleName(),
                ExamineFragment.class.getSimpleName(),
                AskFragment.class.getSimpleName(),
                MineFragment.class.getSimpleName()
        };

        fragmentManager = getSupportFragmentManager();

        rbMainMenuHome.setChecked(true);

        showFragment(checkIndex);
    }

    /**
     * 显示指定的fragment
     * @param index 需要显示的fragment下标
     */
    public void showFragment(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag(fragmentTags[index]);
        //判断fragment是否添加
        if (fragment == null) {
            fragment = mFragment[index];
        }
        //如果当前点击的fragement不是选中的fragment，则隐藏之前的fragment
        if (checkIndex != index) {
            //将之前显示的fragment隐藏
            Fragment f = fragmentManager.findFragmentByTag(fragmentTags[checkIndex]);
            if (f != null && f.isAdded()) {
                //隐藏
                transaction.hide(f);
            }
        }
        //fragment是否已经加入fragmentActivity
        if(fragment.isAdded()){
            transaction.show(fragment);
        }else{
            transaction.add(R.id.fl_menu_content,fragment,fragmentTags[index]);
        }


        transaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        //更新checkIndex
        checkIndex=index;

    }


}
