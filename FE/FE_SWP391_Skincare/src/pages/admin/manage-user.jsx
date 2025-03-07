import { Button, Form, Input, Modal, Space, Table, Tag } from "antd";
import React, { useEffect, useState } from "react";
import api from "../../config/axios";

import FormItem from "antd/es/form/FormItem";

function ManageUser() {
  const [isOpen, setOpen] = useState(false);
  const [userList, setUserList] = useState([]);
  //fetch account users
  const fetchUsers = async () => {
    console.log("fetch ne em");
    const response = await api.get("/users");
    console.log(response.data);
    console.log("fetch xong roi ne em");
    setUserList(response.data);
  };
  useEffect(() => {
    fetchUsers();
  }, []);

  const columns = [
    {
      title: "ID",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Role",
      dataIndex: "role",
      key: "role",
    },
    {
      title: "Email",
      dataIndex: "email",
      key: "email",
    },
    {
      title: "Action",
      key: "action",
    },
  ];
  const handleOpenModal = () => {
    setOpen(true);
  };
  const handleCloseModal = () => {
    setOpen(false);
  };

  return (
    <div>
      <h1>ManageUser</h1>
      <Button onClick={handleOpenModal}>Add new user</Button>
      <Table columns={columns} dataSource={userList} />;
      <Modal
        title="Create new user"
        open={isOpen}
        onClose={handleCloseModal}
        onCancel={handleCloseModal}
      >
        <Form labelCol={{
          span: 24,
        }}>
        <FormItem
            label="Name"
            name="name"
            rules={[
              {
                required: true,
                message: "Name can not be empty",
              },
            ]}
          >
            <Input></Input>
          </FormItem>
          <FormItem
            label="Role"
            name="role"
            rules={[
              {
                required: true,
                message: "Role can not be empty",
              },
            ]}
          >
            <Input></Input>
          </FormItem>
          <FormItem
            label="Email"
            name="email"
            rules={[
              {
                required: true,
                message: "Email can not be empty",
              },
            ]}
          >
            <Input></Input>
          </FormItem>

        </Form>
      </Modal>
    </div>
  );
}

export default ManageUser;
