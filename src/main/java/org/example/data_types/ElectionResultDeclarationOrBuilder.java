// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data_types.proto

package org.example.data_types;

public interface ElectionResultDeclarationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ElectionResultDeclaration)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 leaderId = 1;</code>
   */
  int getLeaderId();

  /**
   * <code>uint32 leaderVoterId = 2;</code>
   */
  int getLeaderVoterId();

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

  /**
   * <code>uint64 clock = 4;</code>
   */
  long getClock();
}
