package com.exerciting.FipeTableConsult.service;

import java.util.List;

public interface ConvertDataInterface {
<G> G converter(String json,Class<G> type);
<G> List<G> convertToList(String json, Class<G> type);

}
