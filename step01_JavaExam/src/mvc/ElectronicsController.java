package mvc;
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
	   //인수로 전달된 정보에서 상품번호를 꺼내서 중복여부를 체크한다.
       Electronics dbElec = service.searchByModelNo(electronics.getModelNo());

       //중복아니면 insert하고 중복이면 에러메시지 출력을 호출한다.
	   if(dbElec!=null){
           EndView.printMessage(electronics.getModelNo()+"는 이미 등록된 상품입니다.");
	   }else{
           if( service.insert(electronics) ){
               EndView.printMessage("등록되었습니다.");
		   }else{
               EndView.printMessage("더 이상 등록 할수 없습니다.");
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
      //서비스를 호출하고 그 결과를 받아서 결과뷰를 호출해준다.
	 Electronics electronics = service.searchByModelNo(modelNo);
	 if(electronics==null){
          EndView.printMessage(modelNo+"에 해당하는 정보는 없습니다.");
	 }else{
          EndView.printSearchByModelNo(electronics);
	 }
   }

   /**
      모델번호에 해당하는 전자제품 수정하기
   */
   public void update(Electronics electronics){ //번호, 설명
         if( service.update(electronics) ){
              EndView.printMessage(electronics.getModelNo()+"에 해당하는 정보가 수정되었습니다.");
		 }else{
              EndView.printMessage(electronics.getModelNo()+"는 수정 할수 없습니다.");
		 }
   }
}