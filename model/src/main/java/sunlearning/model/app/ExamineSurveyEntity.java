package sunlearning.model.app;

import java.sql.Timestamp;

/**
 * Created by chenny on 2018/4/8.
 */

public class ExamineSurveyEntity {
    private int actTestHistoryId;
    private int qnId;
    private String qnName;
    private int testId;
    private String qnStatus;
    private Timestamp endDate;
    private Timestamp startDate;

    public ExamineSurveyEntity(int actTestHistoryId, int qnId, String qnName, int testId, String qnStatus, Timestamp endDate, Timestamp startDate) {
        this.actTestHistoryId = actTestHistoryId;
        this.qnId = qnId;
        this.qnName = qnName;
        this.testId = testId;
        this.qnStatus = qnStatus;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public int getActTestHistoryId() {
        return actTestHistoryId;
    }

    public void setActTestHistoryId(int actTestHistoryId) {
        this.actTestHistoryId = actTestHistoryId;
    }

    public int getQnId() {
        return qnId;
    }

    public void setQnId(int qnId) {
        this.qnId = qnId;
    }

    public String getQnName() {
        return qnName;
    }

    public void setQnName(String qnName) {
        this.qnName = qnName;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getQnStatus() {
        return qnStatus;
    }

    public void setQnStatus(String qnStatus) {
        this.qnStatus = qnStatus;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
}
