package Student;

/**
 * Created by Administrator on 2018/6/21.
 */

import java.io.Serializable;

public class Order implements Serializable{
	private long id;
	private String startplace;
	private String endplace;
	private String starttime;
	private String endtime;
	public Order() {
		super();
	}
	public Order(long id, String startplace, String endplace, String starttime,String endtime) {
		super();
		this.id = id;
		this.startplace = startplace;
		this.endplace = endplace;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public Order(String startplace, String endplace, String starttime,String endtime) {
		super();
		this.startplace = startplace;
		this.endplace = endplace;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStartplace() {
		return startplace;
	}
	public void setStartplace(String startplace) {
		this.startplace = startplace;
	}
	public String getEndplace() {
		return endplace;
	}
	public void setEndplace(String endplace) {
		this.endplace = endplace;
	}
	public String getStarttime() {
		return starttime;     }
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;     }
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
}