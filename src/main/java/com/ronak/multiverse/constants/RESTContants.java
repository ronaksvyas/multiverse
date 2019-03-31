package com.ronak.multiverse.constants;

public class RESTContants {
  public static final String GET_ALL = "/";
  public static final String SAVE_ONE = "/save-one";
  public static final String GET_BY_ID = "/id";
  public static final String SAVE_ALL = "/save-all";
  public static final String DEL_BY_ID = "/del-id/{id}";
  public static final String UNIVERSE = "/universe";
  public static final String PERSON = "/person";
  public static final String FAMILY = "/family";
  public static final String FAMILIES_IN_UNIVERSE = "/{"+ ParamConstants.UNIVERSE_ID+"}/families";
  public static final String CHECK_SAME_POWER = "/{" +ParamConstants.FAMILY_ID+ "}/same-power";
  public static final String UNBALANCED_FAMILY_ID = "unbalanced";
  public static final String BALANCE_FAMILY = "/{" + ParamConstants.FAMILY_ID+"}/balance";
}
