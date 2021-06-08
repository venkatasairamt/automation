import org.testng.annotations.DataProvider;

public class AddProductDataProvider {

    //Start /admin/add-product
//slug,name,description,category,sub_category,price,discount_amount,final_price,images,units
    @DataProvider(name = "admin_add_product")
    public Object[][] add_product(){
        return new Object[][] {
                {"1","Tamamto","Tamamto fresh","605d7a08fb11c6140799b482","605d7dd5fb11c6140799b483","20","10","10","C:\\Users\\USER\\Desktop\\Images\\bringal.jpg","100"}
        };
    }


}
