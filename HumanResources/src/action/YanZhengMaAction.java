package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YanZhengMaAction extends HttpServlet {
	private static int I_WIDTH = 60;
	private static int I_HEIGHT = 18;
	private static Font font = new Font("", Font.PLAIN, 18);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		// 在内存中创建图像
		BufferedImage image = new BufferedImage(I_WIDTH, I_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		// 在内存中获取画布
		Graphics g = image.getGraphics();
		// 设置画布的背景
		g.setColor(Color.white);
		// 设置画布的填充区域
		g.fillRect(0, 0, I_WIDTH, I_HEIGHT);
		// 在区域上添加边框线
		g.setColor(Color.red);
		g.drawRect(0, 0, I_WIDTH - 1, I_HEIGHT - 1);
		// 产生一个5位数的随机数（10000~99999）
		int code = 10000 + (int) (Math.random() * 90000);
		request.getSession().setAttribute("Code", 
				          Integer.toString(code));
		// 将随机数显示在图像画布上
		g.setColor(Color.blue);
		g.setFont(font);
		g.drawString(Integer.toString(code), 7, 15);
		// 图像生效
		g.dispose();
		// 将图像输出到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
	}

}
