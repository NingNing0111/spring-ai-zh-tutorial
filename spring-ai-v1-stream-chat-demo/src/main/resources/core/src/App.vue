<template>
  <div id="common-layout">
    <el-container>
      <el-main>
        <el-row justify="center">
          <div class="llm-content">
            {{ aiResponse }}
          </div>
          <el-col class="user-operate">
            <el-row justify="center">
              <el-input
                type="textarea"
                resize="none"
                show-word-limit
                :autosize="{ minRows: 6, maxRows: 10 }"
                placeholder="请输入"
                v-model="userInputText"
              />
            </el-row>
            <el-row justify="end" style="margin-top: 20px">
              <el-button type="primary" @click="postSend">Post发送</el-button>
              <el-button type="primary" @click="getSend">Get发送</el-button>
            </el-row>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, computed } from "vue";
import { postStreamChat, getStreamChat } from "./api";

const aiResponse = ref("AI回复的内容");

const userInputText = ref("");

const postSend = () => {
  aiResponse.value = "";
  postStreamChat(userInputText.value, handleMessage, handleError, handleClose);
};

const getSend = () => {
  aiResponse.value = "";
  getStreamChat(userInputText.value, handleMessage, handleError, handleClose);
};

const handleMessage = (e: any) => {
  const dataJson = e.data;
  const responseData = JSON.parse(dataJson);
  const output = responseData.result.output;

  if (output.content !== null) {
    var aiText = output.content;
    aiResponse.value = aiResponse.value + aiText;
  }
};

const handleError = (e: any) => {
  console.log(e);
};

const handleClose = (e: any) => {};
</script>

<style scoped lang="less">
#common-layout {
  height: 100%;
  width: 100%;
}

.llm-content {
  min-height: 60px;
  width: 100%;
  background-color: #292c33;
  border-radius: 12px;
  box-shadow: 2px 6px 4px 3px gray;
  padding: 10px;
  margin: 50px 0px;

  border-right: none;
  padding-right: none;
  color: white;
}
.user-input-box {
  margin-right: 20px;
}
</style>
