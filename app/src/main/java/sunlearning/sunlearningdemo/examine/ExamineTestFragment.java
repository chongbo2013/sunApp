package sunlearning.sunlearningdemo.examine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.examine.adapter.ExamineTestAdapter;
import sunlearning.sunlearningdemo.model.ExamineTestEntity;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;

/**
 * Created by chenny on 2018/4/8.
 */

public class ExamineTestFragment extends Fragment {
    private View view;
    private ListView listView;
    private List<ExamineTestEntity> testList;
    private ExamineTestAdapter testAdapter;
    public ExamineTestFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_examine_test,container,false);
        listView = view.findViewById(R.id.examine_test_list_view);
        initData();
        initWidget();
        initEvent();
        return view;
    }

    private void initEvent() {

    }

    private void initWidget() {
        initListView();
    }

    private void initListView() {
        testAdapter=new ExamineTestAdapter(getContext(),testList);
        listView.setAdapter(testAdapter);
    }

    private void initData() {
        testList= InitDataUtil.getExamineTestList();
    }

}
