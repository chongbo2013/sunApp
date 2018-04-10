package sunlearning.sunlearningdemo.utils.init;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.AskEntity;
import sunlearning.sunlearningdemo.model.CourseEntity;
import sunlearning.sunlearningdemo.model.CourseProjectEntity;
import sunlearning.sunlearningdemo.model.ExamineProjectEntity;
import sunlearning.sunlearningdemo.model.ExamineSurveyEntity;
import sunlearning.sunlearningdemo.model.ExamineTestEntity;
import sunlearning.sunlearningdemo.model.PosterEntity;
import sunlearning.sunlearningdemo.model.UserEntity;
import sunlearning.sunlearningdemo.utils.DateFormatUtil;

/**
 * Created by chenny on 2018/4/3.
 */

public class InitDataUtil {
    public static List<CourseEntity> getCoursesInitData(){
        CourseEntity[] courseArr=new CourseEntity[]{
                new CourseEntity(1,"新经理容易陷入的4个误区1","职场中基层管理类系列课程是围绕企业", R.drawable.icon_course,new Timestamp(new Date().getTime()),20),
                new CourseEntity(2,"新经理容易陷入的4个误区2","职场中基层管理类系列课程是围绕企业",R.drawable.icon_course,new Timestamp(new Date().getTime()),20),
                new CourseEntity(3,"新经理容易陷入的4个误区3","职场中基层管理类系列课程是围绕企业",R.drawable.icon_course,new Timestamp(new Date().getTime()),20),
                new CourseEntity(4,"新经理容易陷入的4个误区4","职场中基层管理类系列课程是围绕企业",R.drawable.icon_course,new Timestamp(new Date().getTime()),20),
                new CourseEntity(5,"新经理容易陷入的4个误区5","职场中基层管理类系列课程是围绕企业",R.drawable.icon_course,new Timestamp(new Date().getTime()),20),
                new CourseEntity(6,"新经理容易陷入的4个误区6","职场中基层管理类系列课程是围绕企业",R.drawable.icon_course,new Timestamp(new Date().getTime()),20),
                new CourseEntity(7,"新经理容易陷入的4个误区7","职场中基层管理类系列课程是围绕企业",R.drawable.icon_course,new Timestamp(new Date().getTime()),20),
                new CourseEntity(8,"新经理容易陷入的4个误区8","职场中基层管理类系列课程是围绕企业",R.drawable.icon_course,new Timestamp(new Date().getTime()),20)
        };
        ArrayList<CourseEntity> courseEntities = new ArrayList<>();
        for(CourseEntity courseEntity:courseArr){
            courseEntities.add(courseEntity);
        }
        return courseEntities;
    }




    public static List<CourseProjectEntity> getCourseProjectsData(){
        List proejctList = new ArrayList();
        proejctList.add(new CourseProjectEntity(1, "Java", R.drawable.icon_course));
        proejctList.add(new CourseProjectEntity(2, "C++", R.drawable.icon_course));
        proejctList.add(new CourseProjectEntity(3, "Python", R.drawable.icon_course));
        proejctList.add(new CourseProjectEntity(4, "Kotlin", R.drawable.icon_course));
        proejctList.add(new CourseProjectEntity(5, "C#", R.drawable.icon_course));
        return proejctList;
    }


    public static CourseProjectEntity getCoursePorject(int id){
        List<CourseProjectEntity> courseProjectsData = getCourseProjectsData();
        for(CourseProjectEntity projectEntity:courseProjectsData){
            if(projectEntity.getId()==id){
                return projectEntity;
            }
        }
        return null;
    }


    public static List<PosterEntity> getPosterEntitiesData(){
        List<PosterEntity> posterEntities = new ArrayList<>();

        posterEntities.add(new PosterEntity("鑫日科首届“晒书晒人生”活动",40,"resources/poster/40/2017081616081720798.jpg",1,"http://www.sunontalent.com/index.php/Info/newsDetail/id/523.html?utm_source=email&utm_medium=word&utm_campaign=email20160728"));
        posterEntities.add(new PosterEntity("在谈判中赢得主动的步骤",41,"resources/poster/41/2017121616124837879.jpg",2,"http://139.159.210.109/announ/announ!detail.action?id=46"));
        posterEntities.add(new PosterEntity("创新思维与训练方法",39,"resources/poster/39/2017091616090281667.jpg",3,"http://www.sunontalent.com/index.php/Info/newsDetail/id/523.html?utm_source=email&utm_medium=word&utm_campaign=email20160728"));
        return posterEntities;
    }


    public static List<String> getPosterPaths(){
        List<PosterEntity> posterEntitiesData = getPosterEntitiesData();
        List<String> paths = new ArrayList<>();
        for(PosterEntity posterEntity:posterEntitiesData){
            paths.add(posterEntity.getBannerImg());
        }
        return paths;
    }

    /**
     * 获得跑马灯数据
     * @return
     */
    public static ArrayList<String> getSwitcherData(){
        ArrayList<String> datas = new ArrayList<>();
        datas.add("在线教育路在何方？看腾");
        datas.add("鑫日科携手滴滴出行打造在线教育");
        datas.add("你晒书 我送奖 分享有礼活动");
        return datas;
    }


    public static List<CourseEntity> getLatestCourse(){
        List<CourseEntity> courseEntities = new ArrayList<>();
        CourseEntity course = new CourseEntity();
        course.setId(10162);
        course.setName("PDF课程");
        course.setImg(R.drawable.home_course_item_1);
        course.setDesc("");
        course.setCommentTotal(0);
        course.setZanId(0);
        course.setViewTotal(5);
        course.setAlreadyZan(0);
        course.setZanTotal(1);
        course.setModifiedDate(new Timestamp(DateFormatUtil.string2Date("2018-04-03 12:02:14","yyyy-MM-dd hh:mm:ss").getTime()));
        courseEntities.add(course);

        course=new CourseEntity();
        course.setId(9338);
        course.setName("在谈判中赢得主动的步骤");
        course.setImg(R.drawable.home_course_item_2);
        course.setDesc("生活类通用课程共120门，涵盖健康饮食、心理健康、运动健身、急救知识、生活礼仪等生活方面的知识，从另一个角度为企业员工提供有趣实用的信息。");
        course.setCommentTotal(18);
        course.setZanId(0);
        course.setViewTotal(1730);
        course.setAlreadyZan(0);
        course.setZanTotal(58);
        course.setModifiedDate(new Timestamp(DateFormatUtil.string2Date("2017-12-13 12:15:48","yyyy-MM-dd hh:mm:ss").getTime()));
        courseEntities.add(course);


        return courseEntities;
    }


    public static List<CourseEntity> getHotestCourse(){
        List<CourseEntity> courseEntities = new ArrayList<>();
        CourseEntity course = new CourseEntity();
        course.setId(9338);
        course.setName("在谈判中赢得主动的步骤");
        course.setImg(R.drawable.home_course_item_2);
        course.setDesc("生活类通用课程共120门，涵盖健康饮食、心理健康、运动健身、急救知识、生活礼仪等生活方面的知识，从另一个角度为企业员工提供有趣实用的信息。");
        course.setCommentTotal(18);
        course.setZanId(0);
        course.setViewTotal(1730);
        course.setAlreadyZan(0);
        course.setZanTotal(58);
        course.setModifiedDate(new Timestamp(DateFormatUtil.string2Date("2017-12-13 12:15:48","yyyy-MM-dd hh:mm:ss").getTime()));
        courseEntities.add(course);

        course=new CourseEntity();
        course.setId(9565);
        course.setName("有了这几招，上司不再是“魔鬼”");
        course.setImg(R.drawable.home_course_item_3);
        course.setDesc("生活类通用课程共120门，涵盖健康饮食、心理健康、运动健身、急救知识、生活礼仪等生活方面的知识，从另一个角度为企业员工提供有趣实用的信息。");
        course.setCommentTotal(1);
        course.setZanId(0);
        course.setViewTotal(357);
        course.setAlreadyZan(0);
        course.setZanTotal(10);
        course.setModifiedDate(new Timestamp(DateFormatUtil.string2Date("2017-09-25 16:46:49","yyyy-MM-dd hh:mm:ss").getTime()));
        courseEntities.add(course);





        return courseEntities;
    }


    public static List<ExamineProjectEntity> getExamineProjectsData(){
        ArrayList<ExamineProjectEntity> list = new ArrayList<>();
        list.add(new ExamineProjectEntity(1,R.drawable.home_course_item_2,"鑫成长"));
        list.add(new ExamineProjectEntity(1,R.drawable.home_course_item_2,"赛福迪项目"));
        list.add(new ExamineProjectEntity(1,R.drawable.home_course_item_2,"测试目录"));
        list.add(new ExamineProjectEntity(1,R.drawable.home_course_item_2,"测试组"));
        return list;
    }


    public static List<ExamineTestEntity> getExamineTestList(){
        List<ExamineTestEntity> list = new ArrayList<>();
        list.add(new ExamineTestEntity(9605,9740,"绩效考核究竟谁应得A","鑫成长","ASSESSING",0,new Timestamp(DateFormatUtil.string2Date("2017-11-04 17:13:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 17:13:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineTestEntity(9563,9672,"中餐饭局时，你会“坐”吗？","鑫成长","ASSESSING",0,new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:16:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2018-12-31 16:16:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineTestEntity(9597,9726,"人际沟通之四只耳朵","鑫成长","ASSESSING",0,new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:15:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2018-12-31 16:15:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineTestEntity(9561,9670,"在谈判中赢得主动的步骤","鑫成长","ASSESSING",0,new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2018-12-31 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineTestEntity(9599,9728,"如何对新进人员进行指导和辅导","鑫成长","NOTSTART",0,new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineTestEntity(9600,9729,"处事不惊领导力","鑫成长","NOTSTART",0,new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        return list;
    }



    public static List<ExamineSurveyEntity> getExamineSurveyList(){
        List<ExamineSurveyEntity> list = new ArrayList<>();
        list.add(new ExamineSurveyEntity(10453,96,"能力差距调查",286,"C",new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineSurveyEntity(10375,76,"培训课程需求调研",219,"C",new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineSurveyEntity(10454,61,"个人工作状况调查问卷",162,"C",new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineSurveyEntity(0,26,"管理者培训需求调查",61,"NOTSTART",new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineSurveyEntity(0,28,"需求管理问卷调查",68,"NOTSTART",new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new ExamineSurveyEntity(0,27,"销售部门培训需求调查问卷",66,"NOTSTART",new Timestamp(DateFormatUtil.string2Date("2017-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime()),new Timestamp(DateFormatUtil.string2Date("2019-05-04 16:14:00","yyyy-MM-dd hh:mm:ss").getTime())));

        return list;
    }


    public static List<UserEntity> getUserEntityList(){
        List<UserEntity> userList=new ArrayList<>();
        userList.add(new UserEntity(187,"马洋阳","Gavin","resources/user/187/086.png"));
        userList.add(new UserEntity(18093,"lucky.liu","lucky.liu","resources/user/18093/014.png"));
        userList.add(new UserEntity(3783,"刘菁","刘特","images/head.png"));
        userList.add(new UserEntity(900,"伍真君","shine","resources/user/900/001.png"));
        userList.add(new UserEntity(223,"朱素菲","Sophy","resources/user/223/099.png"));
        userList.add(new UserEntity(210,"秦蛟","Jack","resources/user/210/015.png"));
        userList.add(new UserEntity(253,"杨诗萌","Mark","resources/user/253/a19dd19b0cc5ce70d48c6bb3e7aab463.png"));
        userList.add(new UserEntity(248,"张伟伟","Will","resources/user/248/022.png"));
        userList.add(new UserEntity(177,"胡青松","Relax","resources/user/177/016.png"));
        userList.add(new UserEntity(194,"严永恒","Angelo","resources/user/194/020.png"));
        return userList;
    }


    public static List<AskEntity> getAskList(){
        List<AskEntity> list=new ArrayList<AskEntity>();
        List<UserEntity> userEntityList = getUserEntityList();

        list.add(new AskEntity(210,"优化配置，提高效率，降低成本",0,0,"PENDING",2,new Timestamp(DateFormatUtil.string2Date("2017-12-05 12:37:30","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(208,"如何快速有效提升个人领导力",0,0,"PENDING",0,new Timestamp(DateFormatUtil.string2Date("2017-11-20 09:43:42","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(210,"用户名给我写错了",1,0,"PENDING",2,new Timestamp(DateFormatUtil.string2Date("2017-09-07 15:30:45","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(184,"新员工如何快速融入工作",4,0,"PENDING",5,new Timestamp(DateFormatUtil.string2Date("2017-05-22 18:32:22","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(170,"本月新员工培训什么时间举行",6,0,"PENDING",0,new Timestamp(DateFormatUtil.string2Date("2017-05-10 11:12:01","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(165,"公司可否提供一个财务方面的培训",1,0,"SOLVED",0,new Timestamp(DateFormatUtil.string2Date("2017-05-09 17:22:27","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(162,"有没有喜欢踢足球的同事，我们组个⚽️队哇，有兴趣的报名。",3,0,"PENDING",0,new Timestamp(DateFormatUtil.string2Date("2017-05-08 12:19:11","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(161,"公司有谁报考过PMP证书？交流一下",1,0,"PENDING",2,new Timestamp(DateFormatUtil.string2Date("2017-05-10 11:12:01","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(160,"各位美女帅哥 请问下公司最新的标准版的销售工具放在哪个共享文件里的？",1,0,"SOLVED",10,new Timestamp(DateFormatUtil.string2Date("2017-05-08 11:56:07","yyyy-MM-dd hh:mm:ss").getTime())));
        list.add(new AskEntity(161,"各位销售同学，遇到客户投诉，你们一般都是如何处理的？",1,0,"SOLVED",1,new Timestamp(DateFormatUtil.string2Date("2017-05-08 11:52:08","yyyy-MM-dd hh:mm:ss").getTime())));


        for(int i=0;i<list.size();i++){
            list.get(i).setUserEntity(userEntityList.get(i));
        }
        return list;
    }
}
