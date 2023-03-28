package com.yedam.spring.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.spring.user.service.UserListVO;
import com.yedam.spring.user.service.UserVO;

//데이터를 반환하는 컨트롤러
@CrossOrigin
@RestController // @Controller + @ResponseBody => 해당 클래스 내의 모든 컨트롤러는 객체를 반환
public class UserRestController {
	// value = 경로 , method = RequestMethod.POST라는 전역변수 선언
	// 뒤에 method를 정해주면 딱 그 방식으로만 가능하다
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public UserVO insertUser(UserVO userVO) {
		
		System.out.println("name : "+ userVO.getName());
		System.out.println("age : " + userVO.getAge());
		
		return userVO;
	}
	@RequestMapping("/insertUsers")
	public List<UserVO> insertUserLiost(UserListVO userListVO){
		for(UserVO user : userListVO.getList()) {
			System.out.println(user);
		}
		return userListVO.getList();
	}
	
	@RequestMapping("/getUserData")
	public UserVO getUserData(@RequestParam("user") String name,@RequestParam(defaultValue="0", required = false) int age) {
		// @RequestParam("user") 로되어있다면 읽어오는 파라미터 name을 user로 사용하는 것이고 없다면 뒤의 매개변수를 사용
		// @RequestParam의 디폴트는 값이 필수임 ( 넘겨오는 값이 없다면 동작안함 )
		// @RequestParam(required = false) 라고 쓴다면 값을 꼭 넘겨받지 않아도 된다는 뜻
		// defaultValue="0" 만약 값이 null이라면 초기값을 줄 수 있다.
		// 이렇게 쓸거면 VO에 선언한 참조타입을 넣어주어야한다
		// 커맨드 객체와 유사하다
		// 내부에서 처리한걸 보면 매개변수의 이름을 통해 집어 넣는것이다.
		// 하나의 값만 받을때 사용하면 된다
		UserVO userVO = new UserVO();
		userVO.setName(name);
		userVO.setAge(age);
		
		return userVO;
	}
	
	@GetMapping("/getDataList")
	public String getDataList(@RequestParam(required = false) Map<String, Object> map) {
		String message = null;
		if(map.isEmpty()) {
			message = "데이터가 존재하지 않습니다.";
		}else {
			message = "데이터가 생성되었습니다.";
			Set<Map.Entry<String, Object>> entryList = map.entrySet();
			for(Map.Entry<String, Object> entry : entryList) {
				System.out.print("Key : " + entry.getKey());
				System.out.println(", Value : " + entry.getValue());
			}
		}
		return message;
		
	}
	
	@RequestMapping("/getNames")
	public Map<String, Object> getNames(@RequestParam List<String> name){
		// 동일한 이름일때 리퀘스트파람이 가리키는 매개변수의 이름이여함.
		Map<String, Object> map = new HashMap<>();
		map.put("result","Success");
		map.put("data", name);
		
		return map;
	}
	
	@RequestMapping("/getEmpInfo/{employeeId}") // @PathVariable은 매핑 {}안에 들어가는 값을 정해주는거
	public UserVO getEmpInfo(@PathVariable String employeeId) {
		UserVO userVO = new UserVO();
		userVO.setName(employeeId);
		return userVO;
	}
	
	@RequestMapping("/getInfo")
	public UserVO getInfo(@RequestBody UserVO userVO) { // json으로 파싱해서 보내야함
		return userVO;
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestPart MultipartFile[] pic) {
//		System.out.println("name : " + userVO.getName());
//		System.out.println("file : " + userVO.getPic().getOriginalFilename());
		System.out.println(pic[0].getOriginalFilename());
		return "업로드를 완료했습니다.";
	}
	
	
	
}
