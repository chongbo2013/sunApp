package sunlearning.model.app;

import java.sql.Timestamp;

/**
 * Created by chenny on 2018/4/8.
 */

public class ExamineTestEntity {
    private int examActivityId;
    private int moduleId;
    private String examActivityName;
    private String examCatalogName;
    private String examStatus;
    private int appointStatus;
    private Timestamp examStartDate;
    private Timestamp examEndDate;

    public ExamineTestEntity(int examActivityId, int moduleId, String examActivityName, String examCatalogName, String examStatus, int appointStatus, Timestamp examStartDate, Timestamp examEndDate) {
        this.examActivityId = examActivityId;
        this.moduleId = moduleId;
        this.examActivityName = examActivityName;
        this.examCatalogName = examCatalogName;
        this.examStatus = examStatus;
        this.appointStatus = appointStatus;
        this.examStartDate = examStartDate;
        this.examEndDate = examEndDate;
    }

    public int getExamActivityId() {
        return examActivityId;
    }

    public void setExamActivityId(int examActivityId) {
        this.examActivityId = examActivityId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getExamActivityName() {
        return examActivityName;
    }

    public void setExamActivityName(String examActivityName) {
        this.examActivityName = examActivityName;
    }

    public String getExamCatalogName() {
        return examCatalogName;
    }

    public void setExamCatalogName(String examCatalogName) {
        this.examCatalogName = examCatalogName;
    }

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public int getAppointStatus() {
        return appointStatus;
    }

    public void setAppointStatus(int appointStatus) {
        this.appointStatus = appointStatus;
    }

    public Timestamp getExamStartDate() {
        return examStartDate;
    }

    public void setExamStartDate(Timestamp examStartDate) {
        this.examStartDate = examStartDate;
    }

    public Timestamp getExamEndDate() {
        return examEndDate;
    }

    public void setExamEndDate(Timestamp examEndDate) {
        this.examEndDate = examEndDate;
    }
}
