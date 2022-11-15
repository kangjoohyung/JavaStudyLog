package ex0805.map.exam;

import java.util.HashMap;
import java.util.Map;

public class MapStudentService {
  private Map<String, Person> map = new HashMap<String, Person>();
  
  /**
   *  샘플데이터를 map에 생성자를 이용해서 저장한다.
   * */
   public MapStudentService() {
	   
	   map.put("jang", this.create("jang", "장희정", 22)); //Person
	   map.put("kim", this.create("kim", "김희선", 25)); //Person
	   
	   map.put("queen", this.create("queen", "이효리", 40,70,80,90)); //Student 
	   map.put("king", this.create("king", "송중기", 33,80,90,60));//Student 
	   map.put("girl", this.create("girl", "송혜교", 30,95,95,70));//Student 
   }
  
   /**
    *  map에 저장할 객체를 생성해서 리턴해주는 메소드
    *    ex)Person or Student 리턴
    *  
    * */
    public Person create(String id, String name, int age , int ... params){
    	 
    	 if(params.length==0) {
    		return new Person(id, name, age);
    	 }else {
    		return new Student(id, name, age, params[0], params[1], params[2]);
    	 }
    }//create끝
    
    /**
     * 전체검색하기 
     * */
    public Map<String, Person> selectAll(){
    	
    	if(map.isEmpty()) {
    		throw new RuntimeException("게시물이 존재하지 않습니다.");
    	}
    	
    	return map;
    }
    
    /**
     * key에 해당하는 정보 검색
	 *   :key해당하는 정보를 출력할때 
	 *    [ Person인경우는 이름만 출력
	 *     Student인경우는 이름과 총점 출력 ] -> EndView에서 
	 *     없는경우는 "id는 없습니다." 예외발생
     * */
    public Person searchByKey(String key) {
    	Person p = map.get(key);
    	if(p==null) throw new RuntimeException(key+"에 해당하는 정보는 없습니다.");
    	return p;
    }
     
    /**
     * 등록하기 
     * */
    public void insert(Person person) {
    	
    	if(map.containsKey( person.getId() )) {
    		throw new RuntimeException(person.getId()+"는 중복이므로 등록할수 없습니다.");
    	}
    	
    	map.put(person.getId() , person);
    }
    
    /**
     *삭제하기 
     * */
    public void delete(String key) {
    	Person p = map.remove(key); // 제거가 될 객체를 리턴해준다.
    
        if(p==null)throw new RuntimeException("삭제되지 않았습니다.");
    }
    
    /**
     * 수정하기 
	 *   만약, Person인경우 - 이름만 수정
	 *         Student인경우  - 이름, 국어 ,영어,수학수정(총점 변경)
	 *         
	 *    수정이 안된다면 예외발생
     * */
    public void update(Person person) {//수정하려는 id
    	Person savedPerson = map.get(person.getId());
    	if(savedPerson ==null)
    		throw new RuntimeException(person.getId()+ "는 잘못되어 수정 할수 없습니다.");
    	
        
    	 if(savedPerson instanceof Student) {
    		 if(person instanceof Student) {
    			 //수정하자
    			 savedPerson.setName(  person.getName() );
    			
    			  //ObjectDownCasting을 해서 국어, 영어,수학, 총점 변경해보자
    			  Student savedSt = (Student) savedPerson;
    			  Student paramSt = (Student) person;
    			  
    			  savedSt.setKor(paramSt.getKor());
    			  savedSt.setEng(paramSt.getEng());
    			  savedSt.setMath(paramSt.getMath());
    			  
    			  //총점 변경
    			  int sum = savedSt.getKor() + savedSt.getEng() + savedSt.getMath();
    			  
    			  savedSt.setSum(sum);
    			 
    		 }else {
    			 throw new RuntimeException("타입 오류로 수정 할수 없습니다.");
    		 }
    		 
    		 
    	 }else {
    		 //Person이다.
    		 savedPerson.setName(person.getName());//이름 변경!!!
    	 }
    
    }
    
    
}































