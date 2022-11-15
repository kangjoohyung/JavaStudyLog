package mvc;

import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
  전자제품에 관련된 기능을 담당할 클래스  - 싱글톤 클래스
*/
class ElectronicsService{
   public static int count; //배열방에 저장된 전자제품의 개수를체크!!

 // 초기치 데이터 정보 
   String [][] data = new String [][]{
		{"100","선풍기","35000","삼성 선풍기"},
		{"200","전자렌지","55000","잘 데워져요.."},
		{"300","에어컨","5500000","무풍 에어컨 너무 시원해"},
		{"400","냉장고","800000","LG 냉장고"},
		{"500","드라이기","9000","LG 드라이기"}
	}; 


   private static ElectronicsService instance = new  ElectronicsService(); //private생성자 호출됨

   //영속성 : 전자제품 정보를 저장하고 관리(등록, 검색, 수정, 삭제.....)
   Electronics elecArr []  ; //공간 생성
   
    /**
	  외부에서 객체 생성안됨.
	*/
    private ElectronicsService(){
		System.out.println("private 생성자 호출됨.....");
        //데이터를 초기화 세팅 
        elecArr = new Electronics[7];

        for(int i=0; i < data.length ; i++){

          elecArr[ ElectronicsService.count ] = 
			  new Electronics(Integer.parseInt(data[i][0]) ,data[i][1],Integer.parseInt(data[i][2]),data[i][3]);

		  ElectronicsService.count++;
        }

     }//생성자끝

    /**
	   현재 객체를 리턴해준다.
	*/
	public static ElectronicsService getInstance(){
          return instance;
	}

    /**
	   전자제품 등록
	      배열의 길이를 벗아났을때 ElectronicsArrayBoundsException 발생시켜라.
	*/
    public void insert(Electronics electronics)throws ElectronicsArrayBoundsException{//번호, 이름,가격, 설명
         //배열의 길이가 벗어났는지만 체크하고 
         if(elecArr.length <= ElectronicsService.count){
              throw new ElectronicsArrayBoundsException("더 이상 등록 할수 없습니다.");
		 }

		 elecArr[ElectronicsService.count++ ] = electronics;
        
	}

    /**
	   등록된 전체 전자제품 검색
	*/
	public Electronics [] selectAll(){

      return elecArr;
	}

    /**
	   모델번호에 해당하는 전자제품 검색
	    @return : null이면 없다, null아니면 찾은 객체 리턴
	*/
	public Electronics searchByModelNo(int modelNo)throws SearchNotFoundException{
         for(int i=0; i< ElectronicsService.count ; i++){
                 Electronics elec = elecArr[i];
				 if(elec.getModelNo()  == modelNo){
                      return elec;
				 }
		 }
       
         //못찾았다!!
         throw new SearchNotFoundException(modelNo+"코드 오류로 검색할수 없습니다.");
	}
	/**
	   모델번호에 해당하는 전자제품 수정하기 
	    (설명만 수정한다)
		
	*/
	public void update(Electronics electronics)throws SearchNotFoundException{ //상품번호, 설명
		
          Electronics saveElec = this.searchByModelNo( electronics.getModelNo() );
       
          //수정하자
		  saveElec.setModelDetail( electronics.getModelDetail() );
		

       
	}


}//클래스끝




