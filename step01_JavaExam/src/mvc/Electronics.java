package mvc;
/**
  전자제품의 속성을 관리하는 객체
    : Value Object = Data Transfer Object
*/
public class Electronics{
    private int modelNo;// 상품번호
	private String modelName; //상품이름
	private int modelPrice;//가격
	private String modelDetail;//설명

	//생성자 3개
	public Electronics(){}

	//수정할때 사용할 생성자
	public Electronics(int modelNo, String modelDetail){
        this.modelNo = modelNo;
		this.modelDetail = modelDetail;
	}

	public Electronics(int modelNo, String modelName, int modelPrice, String modelDetail){
       this(modelNo, modelDetail);// 생성자구현부 첫번째 줄에서 다른 생성자 호출

	   this.modelName=modelName;
	   this.modelPrice = modelPrice;
	}

	//set , get 작성
	//setXxx() : public 리턴void , 인수필수
  public void setModelNo(int modelNo){
        this.modelNo=modelNo;
  }
  public void setModelName(String modelName){
      this.modelName=modelName;
  }
  public void setModelPrice(int modelPrice){
        this.modelPrice=modelPrice;
  }
  public void setModelDetail(String modelDetail){
      this.modelDetail=modelDetail;
  }


  //getXxx() : public 리턴필수, 인수없음
  public int getModelNo(){
        return modelNo;
  }
  public String getModelName(){
      return modelName;
  }
  public int getModelPrice(){
        return modelPrice;
  }
  public String getModelDetail(){
      return modelDetail;
  }

@Override
public String toString() {
	
	   
	StringBuilder builder = new StringBuilder();
	builder.append("Electronics [modelNo=");
	builder.append(modelNo);
	builder.append(", modelName=");
	builder.append(modelName);
	builder.append(", modelPrice=");
	builder.append(modelPrice);
	builder.append(", modelDetail=");
	builder.append(modelDetail);
	builder.append("]");
	return builder.toString();
}

    
}