package part01.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import part01.dto.EmpDTO;

/*
 *  apache.org => iBatis => jdk1.4 이상
 *  google.com => myBatis => jdk1.5 이상
 */
public class EmployeesDAO {
	private SqlSession session;
	
	public EmployeesDAO() {
		//1. 트랜잭션이 설정되어 있는 파일의 경로를 정의한다.
		String resoure = "config/configuration.xml";
		
		//2. 설정파일을 로딩하기 위해 입출력스트림과 연결한다.
		try(Reader reader = Resources.getResourceAsReader(resoure)) {
			
			//3. 설정파일을 저장하기 위한 팩토리를 생성해 줄 수 있는 빌더를 생성한다.
			SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
		
			//4. 설정파일의 정보를 읽어와 sqlBuilder에 생성한다.
			SqlSessionFactory factory = sqlBuilder.build(reader);
	    
			//5. 쿼리문에 접근할 수 있도록 sqlSession객체를 리턴한다.
			//openSession()의 기본값은 false이다.
			//자동커밋을 설정하고 싶으면 openSession(true)로 설정한다.
			//실무에서는 자동커밋을 사용하지 않는다.
			session = factory.openSession(true);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end EmployeesDAO()
	
	public int countMethod() {
		 //결과가 하나이면 selectOne(namespace.id)
		return session.selectOne("emp.cnt");
	}//end countMethod()
	
	public List<EmpDTO> listMethod(){
		   //결과가 하나가 아니면 selectList
		return session.selectList("emp.list");
	}//end listMethod()
	
	public List<EmpDTO> searchMethod(String data){
		return session.selectList("emp.searchList", data);
	}
}//end class
