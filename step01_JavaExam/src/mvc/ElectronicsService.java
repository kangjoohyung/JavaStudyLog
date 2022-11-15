package mvc;
/**
  ������ǰ�� ���õ� ����� ����� Ŭ����  - �̱��� Ŭ����
*/
class ElectronicsService{
   public static int count; //�迭�濡 ����� ������ǰ�� ������üũ!!

 // �ʱ�ġ ������ ���� 
   String [][] data = new String [][]{
		{"100","��ǳ��","35000","�Ｚ ��ǳ��"},
		{"200","���ڷ���","55000","�� ��������.."},
		{"300","������","5500000","��ǳ ������ �ʹ� �ÿ���"},
		{"400","�����","800000","LG �����"},
		{"500","����̱�","9000","LG ����̱�"}
	}; 


   private static ElectronicsService instance = new  ElectronicsService(); //private������ ȣ���

   //���Ӽ� : ������ǰ ������ �����ϰ� ����(���, �˻�, ����, ����.....)
   Electronics elecArr []  ; //���� ����
   
    /**
	  �ܺο��� ��ü �����ȵ�.
	*/
    private ElectronicsService(){
		System.out.println("private ������ ȣ���.....");
        //�����͸� �ʱ�ȭ ���� 
        elecArr = new Electronics[7];

        for(int i=0; i < data.length ; i++){

          elecArr[ ElectronicsService.count ] = 
			  new Electronics(Integer.parseInt(data[i][0]) ,data[i][1],Integer.parseInt(data[i][2]),data[i][3]);

		  ElectronicsService.count++;
        }

     }//�����ڳ�

    /**
	   ���� ��ü�� �������ش�.
	*/
	public static ElectronicsService getInstance(){
          return instance;
	}

    /**
	   ������ǰ ���
	   return : true�̸� ��ϼ���, 
	             false�̸� ��Ͻ��� - �迭�� ���̸� ���Ƴ����� 
	*/
    public boolean insert(Electronics electronics){//��ȣ, �̸�,����, ����
         //�迭�� ���̰� ��������� üũ�ϰ� 
         if(elecArr.length <= ElectronicsService.count){
              return false;
		 }

		 elecArr[ElectronicsService.count++ ] = electronics;
        return true;
	}

    /**
	   ��ϵ� ��ü ������ǰ �˻�
	*/
	public Electronics [] selectAll(){

      return elecArr;
	}

    /**
	   �𵨹�ȣ�� �ش��ϴ� ������ǰ �˻�
	    @return : null�̸� ����, null�ƴϸ� ã�� ��ü ����
	*/
	public Electronics searchByModelNo(int modelNo){
         for(int i=0; i< ElectronicsService.count ; i++){
                 Electronics elec = elecArr[i];
				 if(elec.getModelNo()  == modelNo){
                      return elec;
				 }
		 }
       return null;
	}
	/**
	   �𵨹�ȣ�� �ش��ϴ� ������ǰ �����ϱ� 
	    (������ �����Ѵ�)
		@return : true�̸� ��������, false�̸� ��������
	*/
	public boolean update(Electronics electronics){ //��ǰ��ȣ, ����
        Electronics saveElec = this.searchByModelNo( electronics.getModelNo() );
        if(saveElec==null){
              return false;
		}

        //��������
		saveElec.setModelDetail( electronics.getModelDetail() );

        return true;
	}


}//Ŭ������