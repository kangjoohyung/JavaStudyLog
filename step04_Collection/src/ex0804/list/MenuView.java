package ex0804.list;
import java.util.List;
import java.util.Scanner;

/**
   ������� ��û�� Ű����� �Է¹޴� Ŭ���� 
*/
public class MenuView{
    Scanner sc= new Scanner(System.in);
    
	StudentService service = new StudentServiceImpl();
	
	/**
	  ��ü �޴��� ����ϴ� �޼ҵ�
	*/
	public void printMenu(){
        
	     while(true){
           System.out.println("-----------------------------------------------------------------------------");
           System.out.println("1. ��ü�˻�    2. �л���ȣ�˻�     3.���     4. ����    5. ����    9. ����");
		   System.out.println("-----------------------------------------------------------------------------");
		   System.out.print("�޴����� > ");

		   String  menu = sc.nextLine();
		   switch(menu){
               case "1" : 
            	   List<Student> list = service.selectAll();
            	   EndView.printAll(list);
			   break;
			   case "2" : 
                 this.inputSearch();
			   break;
			   case "3" : 
                 this.inputInsert();
			   break;
			   case "4" : 
                 this.inputUpdate();
			   break;
			   case "5" : 
	              this.inputDelete();
				break;
			   case "9" : 
                 System.exit(0);
			   default:
				   System.out.println("�޴��� �ٽ� �������ּ���!!!!");

		   }//switch����

		 }//while����

	}//�޼ҵ峡

	/**
	   ����Ҷ� Ű���� �Է��� ó���ϴ� �޼ҵ�
	*/
	public void inputInsert(){
        System.out.print("�л���ȣ��? ");
        String sno = sc.nextLine();

		System.out.print("�л��̸���? ");
        String name = sc.nextLine();

		System.out.print("�л�������? ");
        int age = Integer.parseInt(sc.nextLine());

		System.out.print("�л� �ּҴ�? ");
        String addr = sc.nextLine();

        boolean result = service.insert( new Student(sno, name, age, addr) );
        
        if(result)EndView.printMessage("��ϵǾ����ϴ�.");
        else EndView.printMessage("��ϵ��� �ʾҽ��ϴ�");

	}

	/**
	 �л���ȣ�� �ش��ϴ� �л����� �˻��ϱ� ���ؼ� �л���ȣ Ű�����Է� ó���ϴ� �޼ҵ�
	*/
    public void inputSearch(){
       System.out.print("ã�� �л���ȣ��? ");
        String sno = sc.nextLine();
        
        Student st = service.selectBySno(sno);
        if(st == null) {
        	EndView.printMessage(sno+"�� �ش��ϴ� �л� ������ �����ϴ�.");
        }else {
            EndView.printSearchBySno(st);
        }
   
	}


	/**
	  �л���ȣ�� �ش��ϴ� �л��� ���̿� �ּҸ� �����ϱ� ���� Ű���� �Է�ó���ϴ� �޼ҵ�
	*/
	public void inputUpdate(){
         System.out.print("�����Ϸ��� �л���ȣ��? ");
         String sno = sc.nextLine();

		System.out.print("�����Ϸ��� ���̴�? ");
        int age = Integer.parseInt(sc.nextLine());
        
        System.out.print("�����Ϸ��� �ּҴ�? ");
        String addr = sc.nextLine();

		boolean result = service.update( new Student(sno, age, addr)) ;
		if(result)EndView.printMessage("�����Ǿ����ϴ�.");
		else EndView.printMessage("�������� �ʾҽ��ϴ�.");

	}
	
	/**
	 * �л� ��ȣ�� �ش��ϴ� ���� ������ ���� Ű���� �Է� �޼ҵ�
	 * */
	public void inputDelete(){
       System.out.print("���� �� �л� ��ȣ��? ");
       String sno  = sc.nextLine();
			
        boolean result = service.delete(sno);
        
        if(result)EndView.printMessage("�����Ǿ����ϴ�.");
        else EndView.printMessage("�������� �ʾҽ��ϴ�.");
	   
	}

	
	

}





