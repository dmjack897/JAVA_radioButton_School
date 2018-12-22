package input;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inputServlet
 */
@WebServlet("/inputServlet")
public class inputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	///////원래 내용을 수정해 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストの文字コード設定
		request.setCharacterEncoding("UTF-8");
		
		//リクエストオブジックトから入力データを受け取り
		String nm = request.getParameter("nm");
		
		//エラー番号
		int intErr = 0;
		//テキストデータが未入力がチエックする。
		if(nm.isEmpty())
		{
			//エラー番号設定
			//-1:名前の未入力エラー
			intErr = -1;
		}
		
		//リクエストにラジオボタンの値があるかチェック(null判定)
		if(request.getParameter("gender")!=null)
		{
			//ラジオボタンの値を取得する。(ラジオボタンがチェックされていた場合)
			String strGender = request.getParameter("gender");
			//リクエストに設定
			request.setAttribute("gender", strGender);
		}
		//未選択時
		else
		{
			//ラジオボタン未選択時は、エラー番号に-2を加算
			intErr += -2;
		}
		
		//結果画面(result.jsp)に入力データを転送
		//リクエストに入力データを格納
		request.setAttribute("nm", nm);
		//エラー番号を格納
		request.setAttribute("Err", intErr);
		//転送処理
		RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
		disp.forward(request, response);
		
	}

}
