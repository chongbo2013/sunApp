package sunlearning.model.app;

import java.io.Serializable;

/**
 * Created by chenny on 2018/4/4.
 */

public class PosterEntity  implements Serializable {
    private String bannerName;
    private int bannerId;
    private String bannerImg;
    private int indexNumber;
    private String url;

    public PosterEntity() {
    }

    public PosterEntity(String bannerName, int bannerId, String bannerImg, int indexNumber, String url) {
        this.bannerName = bannerName;
        this.bannerId = bannerId;
        this.bannerImg = bannerImg;
        this.indexNumber = indexNumber;
        this.url = url;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
