import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.zx.dao.IEmpAccountDao;
import com.zx.dao.IFoodDao;
import com.zx.dao.IFoodSaleDao;
import com.zx.dao.IFoodWaitDao;
import com.zx.dao.IGuestAccountDao;
import com.zx.dao.ILogRoomDao;
import com.zx.dao.IRoomDao;
import com.zx.dao.IRoomGuestOrderDao;
import com.zx.dao.impl.EmpAccountDaoImpl;
import com.zx.dao.impl.FoodDaoImpl;
import com.zx.dao.impl.FoodSaleDaoImpl;
import com.zx.dao.impl.FoodWaitDaoImpl;
import com.zx.dao.impl.GuestAccountDaoImpl;
import com.zx.dao.impl.LogRoomDaoImpl;
import com.zx.dao.impl.RoomDaoImpl;
import com.zx.dao.impl.RoomGuestDaoImpl;
import com.zx.po.Emp;
import com.zx.po.Food;
import com.zx.po.FoodWait;
import com.zx.po.Guest;
import com.zx.po.LogRoom;
import com.zx.po.Room;
import com.zx.po.RoomGuestOrder;
import com.zx.util.Md5Utils;

public class test1 {

	@Test
	/*
	 * 员工登录功能测试
	 */
	public void testEmpLogin() {
		// Emp e = null;
		// e.setEmpId(100000);
		// e.setEmpPwd("123456");
		IEmpAccountDao empDao = new EmpAccountDaoImpl();
		empDao.EmpLoginRoom("100000", "123456");
	}

	@Test
	/*
	 * 顾客登录功能测试
	 */
	public void testGuestLogin() {
		String guestPhone = "15544845878";
		String guestPwd = "123456";
		IGuestAccountDao guestDao = new GuestAccountDaoImpl();
		Guest guestLoginRs = guestDao.GuestLogin(guestPhone, guestPwd);
	}

	@Test
	/*
	 * 顾客注册功能测试
	 */
	public void testGuestRegister() {
		Guest guest = new Guest("黄仁勋", "123456", "male", "身份证", "178151425572124978", "15555845878", null, null);
		IGuestAccountDao guestDao = new GuestAccountDaoImpl();
		guestDao.GuestRegister(guest);
		System.out.println(guest.toString());
	}

	/*
	 * 查询房间功能测试
	 */
	@Test
	public void testselectRoom() {

		IRoomDao roomDao = new RoomDaoImpl();
		roomDao.selectRoom();

	}

	@Test
	/*
	 * 添加房间功能测试
	 */
	public void testAddRoom() {
		Room room = new Room();
		room.setRoomId(8888);
		room.setRoomName("堪培拉");
		IRoomDao roomDao = new RoomDaoImpl();
		roomDao.addRoom(room);
		System.out.println(room.toString());
	}

	@Test
	/*
	 * 删除房间功能测试
	 */
	public void testDeleteRoom() {
		int roomId = 8888;
		IRoomDao roomDao = new RoomDaoImpl();
		roomDao.deleteRoom(roomId);
	}

	@Test
	/*
	 * 更新房间功能测试
	 *
	 */
	public void testUpdateRoom() {
		Room room = new Room();
		room.setRoomName("圣都国际");
		room.setRoomId(8888);
		IRoomDao roomDao = new RoomDaoImpl();
		roomDao.updateRoom(room);

	}

	@Test
	/*
	 * 根据房间名查询
	 * 
	 */
	public void testSearchRoomByName() {
		String roomName = "港";
		IRoomDao roomDao = new RoomDaoImpl();
		roomDao.searchRoomByName(roomName);
	}

	@Test
	/*
	 * 添加日志（写到数据库的触发器?)
	 * 
	 */
	public void testAddLogRoom() {
		LogRoom logRoom = new LogRoom();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logRoom.setLogTime(sdf.format(date));
		logRoom.setEmpId(100001);
		logRoom.setLogOp("退房");
		logRoom.setDeposit(200);
		ILogRoomDao logRoomDao = new LogRoomDaoImpl();
		logRoomDao.addLogRoom(logRoom);
	}

	/*
	 * 查询所有日志
	 */
	@Test
	public void testSelectLogRoom() {
		ILogRoomDao logRoomDao = new LogRoomDaoImpl();
		logRoomDao.selectLogRoom();
	}

	/*
	 * 根据输入查询日志
	 */
	@Test
	public void testSearchLogRoomByContent() {
		ILogRoomDao logRoomDao = new LogRoomDaoImpl();
		logRoomDao.searchLogRoomByContent(null);
	}

	@Test
	/*
	 * 查看所有待审查食物
	 * 
	 */
	public void testSelectFoodWait() {
		IFoodWaitDao foodWaitDao = new FoodWaitDaoImpl();
		foodWaitDao.selectFoodWait();
	}

	@Test
	/*
	 * 测试添加待审查食物
	 */
	public void testAddFoodWait() {
		FoodWait foodWait = new FoodWait();
		foodWait.setFoodName("夫妻肺片");
		IFoodWaitDao foodWaitDao = new FoodWaitDaoImpl();
		foodWaitDao.addFoodWait(foodWait);
	}

	@Test
	/*
	 * 测试更新待审查食物
	 */
	public void testUpdateFoodWait() {
		FoodWait foodwait = new FoodWait("溜肥肠", 99, '份', null, 100001, "未通过");
		IFoodWaitDao foodWaitDao = new FoodWaitDaoImpl();
		foodWaitDao.updateFoodWait(foodwait);
	}

	@Test
	/*
	 * 测试删除待审查食物
	 */
	public void testDeleteFoodWait() {
		FoodWait foodwait = new FoodWait("溜肥肠", 99, '份', null, 100001, "未通过");
		IFoodWaitDao foodWaitDao = new FoodWaitDaoImpl();
		foodWaitDao.deleteFoodWait(foodwait);
	}

	private IFoodDao foodDao = new FoodDaoImpl();
	Food food = new Food(600024, "麻辣大龙虾", 88, '份');

	/*
	 * 测试查看食物
	 */
	@Test
	public void testSelectFood() {
		foodDao.selectFood();
	}

	/*
	 * 测试添加食物
	 */
	@Test
	public void testAddFood() {
		foodDao.addFood(food);
	}

	/*
	 * 测试更新食物
	 */
	@Test
	public void testUpdateFood() {
		foodDao.updateFood(food);
	}

	/*
	 * 测试删除食物
	 */
	@Test
	public void tesDeleteFood() {
		foodDao.deleteFood(food);
	}

	/*
	 * 测试查询食物
	 */
	@Test
	public void testSelectFoodByContent() {
		foodDao.selectFoodByContent("肉");
	}

	/* @Test */
	/*
	 * 测试时间输出类型
	 */
	/*
	 * public void testDateTime() { Date date = new Date(); DateTime dateTime = new
	 * DateTime(); int secondTimestamp = dateTime.getSecondTimestamp(date);
	 * System.out.println(secondTimestamp); }
	 * 
	 */
	IEmpAccountDao empAccountDao = new EmpAccountDaoImpl();

	@Test
	public void testAddEmp() {
		Emp emp = new Emp();
		emp.setEmpPwd("123456");
		boolean flag = empAccountDao.addEmp(emp);
		if (flag == true) {
			System.out.println("success");
		} else {
			System.out.println("error");
		}
	}

	@Test
	public void testUpdateEmp() {
		Emp emp = new Emp();
		emp.setEmpId("100014");
		emp.setEmpPwd("123456");
		emp.setEmpPwd(Md5Utils.md5(emp.getEmpPwd()));
		emp.setEmpDepart(8888);
		empAccountDao.updateEmp(emp);
	}

	@Test
	public void testDeleteEmp() {
		boolean flag = empAccountDao.deleteEmp("100017");
		if (flag == true) {
			System.out.println("success");
		} else {
			System.out.println("error");
		}
	}

	@Test
	public void testSearchAllEmp() {
		empAccountDao.SearchAllEmp();
	}

	@Test
	public void testSearchEmpByInfo() {
		empAccountDao.SearchEmpByInfo("刀");
	}

	@Test
	public void testSearchFoodSaleByDate() {
		IFoodSaleDao foodSaleDao = new FoodSaleDaoImpl();
		int searchTotalFoodSale = foodSaleDao.searchTotalFoodSale("2018-05-22");
		System.out.println(searchTotalFoodSale);
	}

	@Test
	public void testSelectOrder() {
		IRoomGuestOrderDao rgoDao = new RoomGuestDaoImpl();
		List<RoomGuestOrder> rgoList = rgoDao.searchAllOrder();
		System.out.println(rgoList);
	}

	@Test
	public void testSearchOrderByOrderTime() throws ParseException {
		IRoomGuestOrderDao rgoDao = new RoomGuestDaoImpl();
		/*String cookie = "2018-05-05 11:16:37";
		SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		Date date = sdf.parse(cookie);
		System.out.println(date);
		Date sdate=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cookie);
		RoomGuestOrder searchOrderByOrderTime = rgoDao.searchOrderByOrderTime(date);*/
/*		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		String sdate="2006-06-06 11:16:37";
		Date ddate;
		ddate=sdf.parse(sdate);
		System.out.println(ddate);*/
/*		SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		Date date = sdf.parse("2018-05-05 11:16:37" );
		System.out.println(date);*/
		RoomGuestOrder searchOrderByOrderTime = rgoDao.searchOrderByOrderTime("2018-05-05 11:16:37");
		System.out.println(searchOrderByOrderTime);
	}
}
