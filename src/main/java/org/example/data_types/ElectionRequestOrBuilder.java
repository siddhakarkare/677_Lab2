// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data_types.proto

package org.example.data_types;

public interface ElectionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ElectionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 initiator_id = 1;</code>
   */
  int getInitiatorId();

  /**
   * <code>uint32 voter_id = 2;</code>
   */
  int getVoterId();

  /**
   * <code>repeated uint32 path = 3;</code>
   */
  java.util.List<java.lang.Integer> getPathList();
  /**
   * <code>repeated uint32 path = 3;</code>
   */
  int getPathCount();
  /**
   * <code>repeated uint32 path = 3;</code>
   */
  int getPath(int index);
}
