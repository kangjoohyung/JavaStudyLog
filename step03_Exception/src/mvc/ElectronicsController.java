package mvc;

import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
   View와 Model 사이에서 중간 역할.
    : 사용자의 요청을 받아서 그에 해댱하는 서비스를 호출하고
	  호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
*/
class ElectronicsController{
   private ElectronicsService service = ElectronicsService.getInstance() ; //

   /**
      전자제품 등록
   */
   public void insert(Electronics electronics){
	   try {
		   //인수로 전달된 정보에서 상품번호를 꺼내서 중복여부를 체크한다.
		   Electronics dbElec = service.searchByModelNo(electronics.getModelNo());
		   //중복이다.
		   EndView.printMessage("상품코드 중복입니다..");
       
	   }catch (SearchNotFoundException e) {
		   //중복아니다!! --> 등록하러가자.
		   try {
		      service.insert(electronics);
		      EndView.printMessage("등록되었습니다.^^");
		   }catch (ElectronicsArrayBoundsException ex) {
			  EndView.printMessage( ex.getMessage() );
		  }
		   
	  }
       
       
	   
   }//insert 메소드끝 

   /**
     전체검색
   */
   public void selectAll(){
       //서비스를 호출하고 그결과를 받아서 결과뷰를 호출해준다.
        Electronics [] electArr = service.selectAll();
		EndView.printAll(electArr);
   }


   /**
    모델번호에 해당하는 전자제품 검색
   */
   public void searchByModelNo(int modelNo){
	   try {
	      //서비스를 호출하고 그 결과를 받아서 결과뷰를 호출해준다.
		 Electronics electronics = service.searchByModelNo(modelNo);
		 EndView.printSearchByModelNo(electronics);
	   }catch (SearchNotFoundException e) {
		   EndView.printMessage( e.getMessage() );
	   }
	 
   }

   /**
      모델번호에 해당하는 전자제품 수정하기
   */
   public void update(Electronics electronics){ //번호, 설명
	   try {
         service.update(electronics);
         EndView.printMessage("수정되었습니다.");
	   }catch (SearchNotFoundException e) {
		  EndView.printMessage(e.getMessage());
	  }
   }
}













