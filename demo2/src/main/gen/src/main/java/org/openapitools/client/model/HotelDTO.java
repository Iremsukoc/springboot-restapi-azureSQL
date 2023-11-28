/*
 * Hotel Reservation API
 * REST API for managing hotel reservations
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * HotelDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-29T00:09:29.630033300+03:00[Europe/Istanbul]")
public class HotelDTO {
  public static final String SERIALIZED_NAME_HOTEL_I_D = "hotelID";
  @SerializedName(SERIALIZED_NAME_HOTEL_I_D)
  private Integer hotelID;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_AMENITIES = "amenities";
  @SerializedName(SERIALIZED_NAME_AMENITIES)
  private String amenities;

  public static final String SERIALIZED_NAME_CITY = "city";
  @SerializedName(SERIALIZED_NAME_CITY)
  private String city;

  public HotelDTO() {
  }

  public HotelDTO hotelID(Integer hotelID) {
    
    this.hotelID = hotelID;
    return this;
  }

   /**
   * Get hotelID
   * @return hotelID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getHotelID() {
    return hotelID;
  }


  public void setHotelID(Integer hotelID) {
    this.hotelID = hotelID;
  }


  public HotelDTO description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public HotelDTO amenities(String amenities) {
    
    this.amenities = amenities;
    return this;
  }

   /**
   * Get amenities
   * @return amenities
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAmenities() {
    return amenities;
  }


  public void setAmenities(String amenities) {
    this.amenities = amenities;
  }


  public HotelDTO city(String city) {
    
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCity() {
    return city;
  }


  public void setCity(String city) {
    this.city = city;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelDTO hotelDTO = (HotelDTO) o;
    return Objects.equals(this.hotelID, hotelDTO.hotelID) &&
        Objects.equals(this.description, hotelDTO.description) &&
        Objects.equals(this.amenities, hotelDTO.amenities) &&
        Objects.equals(this.city, hotelDTO.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hotelID, description, amenities, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HotelDTO {\n");
    sb.append("    hotelID: ").append(toIndentedString(hotelID)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    amenities: ").append(toIndentedString(amenities)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("hotelID");
    openapiFields.add("description");
    openapiFields.add("amenities");
    openapiFields.add("city");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to HotelDTO
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (HotelDTO.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in HotelDTO is not found in the empty JSON string", HotelDTO.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!HotelDTO.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `HotelDTO` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("amenities") != null && !jsonObj.get("amenities").isJsonNull()) && !jsonObj.get("amenities").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `amenities` to be a primitive type in the JSON string but got `%s`", jsonObj.get("amenities").toString()));
      }
      if ((jsonObj.get("city") != null && !jsonObj.get("city").isJsonNull()) && !jsonObj.get("city").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `city` to be a primitive type in the JSON string but got `%s`", jsonObj.get("city").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!HotelDTO.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'HotelDTO' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<HotelDTO> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(HotelDTO.class));

       return (TypeAdapter<T>) new TypeAdapter<HotelDTO>() {
           @Override
           public void write(JsonWriter out, HotelDTO value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public HotelDTO read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of HotelDTO given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of HotelDTO
  * @throws IOException if the JSON string is invalid with respect to HotelDTO
  */
  public static HotelDTO fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, HotelDTO.class);
  }

 /**
  * Convert an instance of HotelDTO to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
