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

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020data_types.proto\"\'\n\017ElectionRequest\022\024\n" +
      "\014initiator_id\030\001 \001(\r\"\"\n\rElectionReply\022\021\n\t" +
      "leader_id\030\001 \001(\r\".\n\031ElectionResultDeclara" +
      "tion\022\021\n\tleader_id\030\001 \001(\r\"I\n\022TransactionRe" +
      "quest\022\020\n\010buyer_id\030\001 \001(\r\022\024\n\014product_name\030" +
      "\002 \001(\t\022\013\n\003qty\030\003 \001(\r\"\'\n\020TransactionReply\022\023" +
      "\n\013status_code\030\001 \001(\010B\032\n\026org.example.data_" +
      "typesP\001b\006proto3"
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
        new java.lang.String[] { "InitiatorId", });
    internal_static_ElectionReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ElectionReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ElectionReply_descriptor,
        new java.lang.String[] { "LeaderId", });
    internal_static_ElectionResultDeclaration_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ElectionResultDeclaration_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ElectionResultDeclaration_descriptor,
        new java.lang.String[] { "LeaderId", });
    internal_static_TransactionRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_TransactionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TransactionRequest_descriptor,
        new java.lang.String[] { "BuyerId", "ProductName", "Qty", });
    internal_static_TransactionReply_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_TransactionReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TransactionReply_descriptor,
        new java.lang.String[] { "StatusCode", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
