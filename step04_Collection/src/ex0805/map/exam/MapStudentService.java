package ex0805.map.exam;

import java.util.HashMap;
import java.util.Map;

public class MapStudentService {
  private Map<String, Person> map = new HashMap<String, Person>();
  
  /**
   *  ���õ����͸� map�� �����ڸ� �̿��ؼ� �����Ѵ�.
   * */
   public MapStudentService() {
	   
	   map.put("jang", this.create("jang", "������", 22)); //Person
	   map.put("kim", this.create("kim", "����", 25)); //Person
	   
	   map.put("queen", this.create("queen", "��ȿ��", 40,70,80,90)); //Student 
	   map.put("king", this.create("king", "���߱�", 33,80,90,60));//Student 
	   map.put("girl", this.create("girl", "������", 30,95,95,70));//Student 
   }
  
   /**
    *  map�� ������ ��ü�� �����ؼ� �������ִ� �޼ҵ�
    *    ex)Person or Student ����
    *  
    * */
    public Person create(String id, String name, int age , int ... params){
    	 
    	 if(params.length==0) {
    		return new Person(id, name, age);
    	 }else {
    		return new Student(id, name, age, params[0], params[1], params[2]);
    	 }
    }//create��
    
    /**
     * ��ü�˻��ϱ� 
     * */
    public Map<String, Person> selectAll(){
    	
    	if(map.isEmpty()) {
    		throw new RuntimeException("�Խù��� �������� �ʽ��ϴ�.");
    	}
    	
    	return map;
    }
    
    /**
     * key�� �ش��ϴ� ���� �˻�
	 *   :key�ش��ϴ� ������ ����Ҷ� 
	 *    [ Person�ΰ��� �̸��� ���
	 *     Student�ΰ��� �̸��� ���� ��� ] -> EndView���� 
	 *     ���°��� "id�� �����ϴ�." ���ܹ߻�
     * */
    public Person searchByKey(String key) {
    	Person p = map.get(key);
    	if(p==null) throw new RuntimeException(key+"�� �ش��ϴ� ������ �����ϴ�.");
    	return p;
    }
     
    /**
     * ����ϱ� 
     * */
    public void insert(Person person) {
    	
    	if(map.containsKey( person.getId() )) {
    		throw new RuntimeException(person.getId()+"�� �ߺ��̹Ƿ� ����Ҽ� �����ϴ�.");
    	}
    	
    	map.put(person.getId() , person);
    }
    
    /**
     *�����ϱ� 
     * */
    public void delete(String key) {
    	Person p = map.remove(key); // ���Ű� �� ��ü�� �������ش�.
    
        if(p==null)throw new RuntimeException("�������� �ʾҽ��ϴ�.");
    }
    
    /**
     * �����ϱ� 
	 *   ����, Person�ΰ�� - �̸��� ����
	 *         Student�ΰ��  - �̸�, ���� ,����,���м���(���� ����)
	 *         
	 *    ������ �ȵȴٸ� ���ܹ߻�
     * */
    public void update(Person person) {//�����Ϸ��� id
    	Person savedPerson = map.get(person.getId());
    	if(savedPerson ==null)
    		throw new RuntimeException(person.getId()+ "�� �߸��Ǿ� ���� �Ҽ� �����ϴ�.");
    	
        
    	 if(savedPerson instanceof Student) {
    		 if(person instanceof Student) {
    			 //��������
    			 savedPerson.setName(  person.getName() );
    			
    			  //ObjectDownCasting�� �ؼ� ����, ����,����, ���� �����غ���
    			  Student savedSt = (Student) savedPerson;
    			  Student paramSt = (Student) person;
    			  
    			  savedSt.setKor(paramSt.getKor());
    			  savedSt.setEng(paramSt.getEng());
    			  savedSt.setMath(paramSt.getMath());
    			  
    			  //���� ����
    			  int sum = savedSt.getKor() + savedSt.getEng() + savedSt.getMath();
    			  
    			  savedSt.setSum(sum);
    			 
    		 }else {
    			 throw new RuntimeException("Ÿ�� ������ ���� �Ҽ� �����ϴ�.");
    		 }
    		 
    		 
    	 }else {
    		 //Person�̴�.
    		 savedPerson.setName(person.getName());//�̸� ����!!!
    	 }
    
    }
    
    
}































