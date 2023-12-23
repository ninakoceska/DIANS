package com.example.demo.model.response;

import com.example.demo.model.Winery;
import lombok.Data;

import java.util.List;

@Data
public class WineryResponse {

    private List<Winery> wineries;
    private Winery winery;
    private String errorMessage;

    public WineryResponse(List<Winery> wineries) {
        this.wineries = wineries;
    }

    public WineryResponse(Winery winery) {
        this.winery = winery;
    }

    public WineryResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Winery> getWineries() {
        return wineries;
    }

    public void setWineries(List<Winery> wineries) {
        this.wineries = wineries;
    }

    public Winery getWinery() {
        return winery;
    }

    public void setWinery(Winery winery) {
        this.winery = winery;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
