
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProductsByCategoryResponse_QNAME = new QName("http://service/", "getProductsByCategoryResponse");
    private final static QName _GetCategoryList_QNAME = new QName("http://service/", "getCategoryList");
    private final static QName _GetProductInfo_QNAME = new QName("http://service/", "getProductInfo");
    private final static QName _GetAllProducts_QNAME = new QName("http://service/", "getAllProducts");
    private final static QName _GetCategoryListResponse_QNAME = new QName("http://service/", "getCategoryListResponse");
    private final static QName _GetProductsByCategory_QNAME = new QName("http://service/", "getProductsByCategory");
    private final static QName _GetProductInfoResponse_QNAME = new QName("http://service/", "getProductInfoResponse");
    private final static QName _GetAllProductsResponse_QNAME = new QName("http://service/", "getAllProductsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllProductsResponse }
     * 
     */
    public GetAllProductsResponse createGetAllProductsResponse() {
        return new GetAllProductsResponse();
    }

    /**
     * Create an instance of {@link GetProductInfoResponse }
     * 
     */
    public GetProductInfoResponse createGetProductInfoResponse() {
        return new GetProductInfoResponse();
    }

    /**
     * Create an instance of {@link GetProductsByCategory }
     * 
     */
    public GetProductsByCategory createGetProductsByCategory() {
        return new GetProductsByCategory();
    }

    /**
     * Create an instance of {@link GetCategoryListResponse }
     * 
     */
    public GetCategoryListResponse createGetCategoryListResponse() {
        return new GetCategoryListResponse();
    }

    /**
     * Create an instance of {@link GetAllProducts }
     * 
     */
    public GetAllProducts createGetAllProducts() {
        return new GetAllProducts();
    }

    /**
     * Create an instance of {@link GetProductInfo }
     * 
     */
    public GetProductInfo createGetProductInfo() {
        return new GetProductInfo();
    }

    /**
     * Create an instance of {@link GetCategoryList }
     * 
     */
    public GetCategoryList createGetCategoryList() {
        return new GetCategoryList();
    }

    /**
     * Create an instance of {@link GetProductsByCategoryResponse }
     * 
     */
    public GetProductsByCategoryResponse createGetProductsByCategoryResponse() {
        return new GetProductsByCategoryResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsByCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getProductsByCategoryResponse")
    public JAXBElement<GetProductsByCategoryResponse> createGetProductsByCategoryResponse(GetProductsByCategoryResponse value) {
        return new JAXBElement<GetProductsByCategoryResponse>(_GetProductsByCategoryResponse_QNAME, GetProductsByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoryList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCategoryList")
    public JAXBElement<GetCategoryList> createGetCategoryList(GetCategoryList value) {
        return new JAXBElement<GetCategoryList>(_GetCategoryList_QNAME, GetCategoryList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getProductInfo")
    public JAXBElement<GetProductInfo> createGetProductInfo(GetProductInfo value) {
        return new JAXBElement<GetProductInfo>(_GetProductInfo_QNAME, GetProductInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllProducts")
    public JAXBElement<GetAllProducts> createGetAllProducts(GetAllProducts value) {
        return new JAXBElement<GetAllProducts>(_GetAllProducts_QNAME, GetAllProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoryListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCategoryListResponse")
    public JAXBElement<GetCategoryListResponse> createGetCategoryListResponse(GetCategoryListResponse value) {
        return new JAXBElement<GetCategoryListResponse>(_GetCategoryListResponse_QNAME, GetCategoryListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsByCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getProductsByCategory")
    public JAXBElement<GetProductsByCategory> createGetProductsByCategory(GetProductsByCategory value) {
        return new JAXBElement<GetProductsByCategory>(_GetProductsByCategory_QNAME, GetProductsByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getProductInfoResponse")
    public JAXBElement<GetProductInfoResponse> createGetProductInfoResponse(GetProductInfoResponse value) {
        return new JAXBElement<GetProductInfoResponse>(_GetProductInfoResponse_QNAME, GetProductInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllProductsResponse")
    public JAXBElement<GetAllProductsResponse> createGetAllProductsResponse(GetAllProductsResponse value) {
        return new JAXBElement<GetAllProductsResponse>(_GetAllProductsResponse_QNAME, GetAllProductsResponse.class, null, value);
    }

}
