/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.config.constants;

import org.springframework.stereotype.Component;

/**
 *
 * @author nogueirajua
 */
@Component
public class Constants {
    
    public final static String HTTP_SESSION_EMPLOYEE="employee";
    public final static String HTTP_SESSION_MANAGER="manager";
    public final static String HTTP_SESSION_ORGANIZATION="organization";
    public final static String HTTP_SESSION_BUSINESS_UNIT="businessunit";
    
    /*
    Alerts
    */
    public final static String alertFromSystem = "SISTEMA";
    public final static String alertMessageNewComment = "Você possui um novo comentário em suas metas";
    public final static String alertMessageMoreComments = "A meta que você comentou recebeu novos comentários";
    public final static String alertMessageNewGoal = "Você recebeu uma nova meta";
    public final static String alertMessageRejectedGoal = "Sua meta foi rejeitada";
    public final static String alertLinkNewComment = "/goal/goals-details?goalId={goalId}";
    public final static String alertLinkNewIndividualGoal = "/goal/my-goals";
    
    public final static String alertTypeSuccess = "success";
    public final static String alertTypeInfo = "info";
    public final static String alertTypeWarning = "warning";
    public final static String alertTypeDanger = "danger";
    public final static String alertTypeComment = "fa-comment-o";
    public final static String alertTypeGoal = "fa-crosshairs";
    
    
    
    /*
    Goals status
    */
    public final static String goalStatusManagerDraft = "RASCUNHO-GESTOR";
    public final static String goalStatusRejected = "REJECTED";
    public final static String goalStatusDraft = "RASCUNHO";
    public final static String goalStatusApproved = "APROVADO";
    public final static String goalStatusPreApproved = "PRE-APROVADO";
    public final static String goalIdStatusManagerDraft = "493";
    public final static String goalIdStatusRejected = "207";
    public final static String goalIdStatusDraft = "206";
    public final static String goalIdStatusApproved = "205";
    public final static String goalIdStatusPreApproved = "204";
    
    
    /*
    Log goals
    */
    public final static String logGoalWaitingForApproveStatus = "0";
    public final static String logGoalApproved = "1";
    
    
    /*
    Goals Types
    */
    public final static String goalTypeGestao = "210";
    public final static String goalTypeOrganization = "209";
    public final static String goalTypeIndividual = "208";
    
    
}
