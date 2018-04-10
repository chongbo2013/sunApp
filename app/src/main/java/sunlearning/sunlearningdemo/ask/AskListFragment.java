package sunlearning.sunlearningdemo.ask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.ask.adapter.AskListAdapter;
import sunlearning.sunlearningdemo.model.AskEntity;
import sunlearning.sunlearningdemo.utils.enums.AskType;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;
import sunlearning.sunlearningdemo.utils.widegt.NoExistDataTextTip;

/**
 * Created by chenny on 2018/4/8.
 */

public class AskListFragment extends Fragment {
    private AskType askType;
    private ListView listView;
    private LinearLayout containerView;
    private List<AskEntity> askList;
    private AskListAdapter askListAdapter;
    private View view;
    public AskListFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ask_list,container,false);
        containerView=view.findViewById(R.id.ask_list_linealayout);
        listView=view.findViewById(R.id.ask_list_view);
        initData();
        initWidget();
        return view;
    }

    private void initWidget() {
        if(askType==AskType.ALL){
            initListView();
        }else{
            //加入空视图
            listView.setVisibility(View.GONE);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            NoExistDataTextTip noExistDataTextTip = new NoExistDataTextTip(getContext());
            noExistDataTextTip.setVisibility(View.VISIBLE);
            containerView.addView(noExistDataTextTip,-1,layoutParams);
          
        }

    }

    private void initListView() {
        askListAdapter=new AskListAdapter(getContext(),askList);
        listView.setAdapter(askListAdapter);
    }

    private void initData() {
        askList= InitDataUtil.getAskList();
    }

    public AskType getAskType() {
        return askType;
    }

    public void setAskType(AskType askType) {
        this.askType = askType;
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
