package com.projectmanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdReq implements Serializable {

    private static final long serialVersionUID = -2712161940670333204L;

    private Long id;

}
