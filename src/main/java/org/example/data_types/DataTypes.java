// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data_types.proto

package org.example.data_types;

public final class DataTypes {
  private DataTypes() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ElectionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ElectionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ElectionReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ElectionReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ElectionResultDeclaration_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ElectionResultDeclaration_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TransactionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TransactionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TransactionReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TransactionReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SellerOutOfStockNotification_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SellerOutOfStockNotification_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SellerOutOfStockNotificationReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SellerOutOfStockNotificationReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LeaderResignationNotification_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LeaderResignationNotification_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LeaderInitializationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LeaderInitializationRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020data_types.proto\"r\n\017ElectionRequest\022\023\n" +
      "\013contenderId\030\001 \001(\r\022\030\n\020contenderVoterId\030\002" +
      " \001(\r\022\014\n\004path\030\003 \003(\r\022\023\n\013isInitiator\030\004 \001(\010\022" +
      "\r\n\005clock\030\005 \001(\004\"]\n\rElectionReply\022\017\n\007child" +
      "Id\030\001 \001(\r\022\023\n\013contenderId\030\002 \001(\r\022\030\n\020contend" +
      "erVoterId\030\003 \001(\r\022\014\n\004path\030\004 \003(\r\"a\n\031Electio" +
      "nResultDeclaration\022\020\n\010leaderId\030\001 \001(\r\022\025\n\r" +
      "leaderVoterId\030\002 \001(\r\022\014\n\004path\030\003 \003(\r\022\r\n\005clo" +
      "ck\030\004 \001(\004\"X\n\022TransactionRequest\022\020\n\010buyer_" +
      "id\030\001 \001(\r\022\024\n\014product_name\030\002 \001(\t\022\013\n\003qty\030\003 " +
      "\001(\r\022\r\n\005clock\030\004 \001(\004\"\'\n\020TransactionReply\022\023" +
      "\n\013status_code\030\001 \001(\010\"@\n\034SellerOutOfStockN" +
      "otification\022\021\n\ttrader_id\030\001 \001(\r\022\r\n\005clock\030" +
      "\002 \001(\004\"h\n!SellerOutOfStockNotificationRep" +
      "ly\022\021\n\tseller_id\030\001 \001(\r\022\024\n\014product_name\030\002 " +
      "\001(\t\022\013\n\003qty\030\003 \001(\r\022\r\n\005price\030\004 \001(\r\"A\n\035Leade" +
      "rResignationNotification\022\021\n\tleader_id\030\001 " +
      "\001(\r\022\r\n\005clock\030\002 \001(\004\"B\n\033LeaderInitializati" +
      "onRequest\022\024\n\014initiator_id\030\001 \001(\r\022\r\n\005clock" +
      "\030\002 \001(\004B\032\n\026org.example.data_typesP\001b\006prot" +
      "o3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ElectionRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ElectionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ElectionRequest_descriptor,
        new java.lang.String[] { "ContenderId", "ContenderVoterId", "Path", "IsInitiator", "Clock", });
    internal_static_ElectionReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ElectionReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ElectionReply_descriptor,
        new java.lang.String[] { "ChildId", "ContenderId", "ContenderVoterId", "Path", });
    internal_static_ElectionResultDeclaration_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ElectionResultDeclaration_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ElectionResultDeclaration_descriptor,
        new java.lang.String[] { "LeaderId", "LeaderVoterId", "Path", "Clock", });
    internal_static_TransactionRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_TransactionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TransactionRequest_descriptor,
        new java.lang.String[] { "BuyerId", "ProductName", "Qty", "Clock", });
    internal_static_TransactionReply_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_TransactionReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TransactionReply_descriptor,
        new java.lang.String[] { "StatusCode", });
    internal_static_SellerOutOfStockNotification_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_SellerOutOfStockNotification_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SellerOutOfStockNotification_descriptor,
        new java.lang.String[] { "TraderId", "Clock", });
    internal_static_SellerOutOfStockNotificationReply_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_SellerOutOfStockNotificationReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SellerOutOfStockNotificationReply_descriptor,
        new java.lang.String[] { "SellerId", "ProductName", "Qty", "Price", });
    internal_static_LeaderResignationNotification_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_LeaderResignationNotification_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LeaderResignationNotification_descriptor,
        new java.lang.String[] { "LeaderId", "Clock", });
    internal_static_LeaderInitializationRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_LeaderInitializationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LeaderInitializationRequest_descriptor,
        new java.lang.String[] { "InitiatorId", "Clock", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
