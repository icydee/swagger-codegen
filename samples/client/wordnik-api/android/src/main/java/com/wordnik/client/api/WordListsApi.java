package com.wordnik.client.api;

import com.wordnik.client.common.ApiException;
import com.wordnik.client.common.ApiInvoker;
import com.wordnik.client.model.WordList;
import java.util.*;

public class WordListsApi {
  String basePath = "http://api.wordnik.com/v4";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  public WordList createWordList (WordList body, String auth_token) throws ApiException {
    // verify required params are set
    if(auth_token == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/wordLists.{format}".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    headerParams.put("auth_token", auth_token);
    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
      if(response != null){
        return (WordList) ApiInvoker.deserialize(response, "", WordList.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
        return null;
      }
      else {
        throw ex;
      }
    }
  }
  }

