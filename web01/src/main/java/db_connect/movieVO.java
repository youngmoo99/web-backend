package db_connect;

public class movieVO {
	private int movienumber;
	private String moviename;
	private String runningtime;
	private String genre;
	private String screenDate;
	private String img;
	public int getMovienumber() {
		return movienumber;
	}
	public void setMovienumber(int movienumber) {
		this.movienumber = movienumber;
	}
	@Override
	public String toString() {
		return "movieVO [movienumber=" + movienumber + ", moviename=" + moviename + ", runningtime=" + runningtime
				+ ", genre=" + genre + ", screenDate=" + screenDate + ", img=" + img + "]";
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getRunningtime() {
		return runningtime;
	}
	public void setRunningtime(String runningtime) {
		this.runningtime = runningtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
