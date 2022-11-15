package mvc;
/**
   View�� Model ���̿��� �߰� ����.
    : ������� ��û�� �޾Ƽ� �׿� �؈��ϴ� ���񽺸� ȣ���ϰ�
	  ȣ���� ����� �޾Ƽ� ������� ���� ��� �並 ȣ�����ش�.
*/
class ElectronicsController{
   private ElectronicsService service = ElectronicsService.getInstance() ; //

   /**
      ������ǰ ���
   */
   public void insert(Electronics electronics){
	   //�μ��� ���޵� �������� ��ǰ��ȣ�� ������ �ߺ����θ� üũ�Ѵ�.
       Electronics dbElec = service.searchByModelNo(electronics.getModelNo());

       //�ߺ��ƴϸ� insert�ϰ� �ߺ��̸� �����޽��� ����� ȣ���Ѵ�.
	   if(dbElec!=null){
           EndView.printMessage(electronics.getModelNo()+"�� �̹� ��ϵ� ��ǰ�Դϴ�.");
	   }else{
           if( service.insert(electronics) ){
               EndView.printMessage("��ϵǾ����ϴ�.");
		   }else{
               EndView.printMessage("�� �̻� ��� �Ҽ� �����ϴ�.");
		   }
	   }	   
	   
   }//insert �޼ҵ峡 

   /**
     ��ü�˻�
   */
   public void selectAll(){
       //���񽺸� ȣ���ϰ� �װ���� �޾Ƽ� ����並 ȣ�����ش�.
        Electronics [] electArr = service.selectAll();
		EndView.printAll(electArr);
   }


   /**
    �𵨹�ȣ�� �ش��ϴ� ������ǰ �˻�
   */
   public void searchByModelNo(int modelNo){
      //���񽺸� ȣ���ϰ� �� ����� �޾Ƽ� ����並 ȣ�����ش�.
	 Electronics electronics = service.searchByModelNo(modelNo);
	 if(electronics==null){
          EndView.printMessage(modelNo+"�� �ش��ϴ� ������ �����ϴ�.");
	 }else{
          EndView.printSearchByModelNo(electronics);
	 }
   }

   /**
      �𵨹�ȣ�� �ش��ϴ� ������ǰ �����ϱ�
   */
   public void update(Electronics electronics){ //��ȣ, ����
         if( service.update(electronics) ){
              EndView.printMessage(electronics.getModelNo()+"�� �ش��ϴ� ������ �����Ǿ����ϴ�.");
		 }else{
              EndView.printMessage(electronics.getModelNo()+"�� ���� �Ҽ� �����ϴ�.");
		 }
   }
}