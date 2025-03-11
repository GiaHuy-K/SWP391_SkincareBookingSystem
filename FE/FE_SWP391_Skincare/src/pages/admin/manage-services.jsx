import React, { useState, useEffect } from "react";
import { toast, ToastContainer } from "react-toastify";
import api from "../../config/axios";
import {
  Button,
  Form,
  Image,
  Input,
  Modal,
  Popconfirm,
  Table,
  Upload,
} from "antd";
import FormItem from "antd/es/form/FormItem";
import { useForm } from "antd/es/form/Form";
import { PlusOutlined } from "@ant-design/icons";
import { getSkinCareServices } from "../../services/api.skincareservices";
// import uploadFile from "../../utils/upload";

function ManageServices() {
  const [servicesList, setServicesList] = useState([]);
  const [formData] = useForm();
  const [isOpen, setOpen] = useState(false);
  // const [previewOpen, setPreviewOpen] = useState(false);
  // const [previewImage, setPreviewImage] = useState("");
  // const [fileList, setFileList] = useState([]);
  // const handlePreview = async (file) => {
  //   if (!file.url && !file.preview) {
  //     file.preview = await getBase64(file.originFileObj);
  //   }
  //   setPreviewImage(file.url || file.preview);
  //   setPreviewOpen(true);
  // };
  // const handleChange = ({ fileList: newFileList }) => setFileList(newFileList);
  // const uploadButton = (
  //   <button
  //     style={{
  //       border: 0,
  //       background: "none",
  //     }}
  //     type="button"
  //   >
  //     <PlusOutlined />
  //     <div
  //       style={{
  //         marginTop: 8,
  //       }}
  //     >
  //       Upload
  //     </div>
  //   </button>
  // );
  // const getBase64 = (file) =>
  //   new Promise((resolve, reject) => {
  //     const reader = new FileReader();
  //     reader.readAsDataURL(file);
  //     reader.onload = () => resolve(reader.result);
  //     reader.onerror = (error) => reject(error);
  //   });

  const columns = [
    {
      title: "Id",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Duration",
      dataIndex: "duration",
      key: "duration",
    },
    {
      title: "Price",
      dataIndex: "price",
      key: "price",
    },
    {
      title: "Description",
      dataIndex: "description",
      key: "description",
    },
    // {
    //   title: "Image",
    //   dataIndex: "image",
    //   key: "image",
    // render: (image) =><Image src={image} width ={100}/>,
    // },
    {
      title: "Action",
      dataIndex: "id",
      key: "id",
      render: (id, service) => {
        return (
          <>
            <Button
              type="primary"
              onClick={() => {
                setOpen(true);
                formData.setFieldsValue(service);
              }}
            >
              Edit
            </Button>
            <Popconfirm
              title="Delete the service"
              description=" Are you sure to delete this service?"
              onConfirm={() => handleDeleteSevice(id)}
            >
              <Button danger type="primary">
                Delete
              </Button>
            </Popconfirm>
          </>
        );
      },
    },
  ];

  // Delete service
  const handleDeleteSevice = async (id) => {
    try {
      await api.delete(`/admin/skinCareService/${id}`);
      toast.success("Successfully delete service");
      fetchServices();
    } catch (error) {
      toast.error("Failed to delete service: " + error.message);
    }
  };
  // Fetch services
  const fetchServices = async () => {
    const data = await getSkinCareServices();
    setServicesList(data);
  };

  useEffect(() => {
    fetchServices();
  }, []);


  // Modal handlers
  const handleOpenModal = () => {
    setOpen(true);
  };
  const handleCloseModal = () => {
    setOpen(false);
  };
  const handleSumbitForm = async (values) => {
    try {
      if (values.id) {
        await api.put(`/admin/skinCareService/${values.id}`, values);
        toast.success("Successfully edit service");
      } else {
        await api.post("/admin/skinCareService", values);
        toast.success("Successfully create new service");
      }
      handleCloseModal();
      fetchServices();
      formData.resetFields();
    } catch (error) {
      toast.error("Failed to save service: " + error.message);
    }
  };

  return (
    <div>
      <ToastContainer />
      <h1 className="text-center text-3xl font-bold text-green-600 my-4">
        Manage Services
      </h1>
      <Button
        type="primary"
        icon={<PlusOutlined />}
        style={{ backgroundColor: "#06b6d4" }}
        onClick={handleOpenModal}
      >
        Add new service
      </Button>
      <Table dataSource={servicesList} columns={columns} />
      <Modal
        title="Create new service"
        open={isOpen}
        onCancel={handleCloseModal}
        onOk={() => formData.submit()}
      >
        <Form
          labelCol={{
            span: 24,
          }}
          form={formData}
          onFinish={handleSumbitForm}
        >
          <FormItem label="Id" name="id" hidden>
            <Input></Input>
          </FormItem>
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
            label="Description"
            name="description"
            rules={[
              {
                required: true,
                message: "Description can not be empty",
              },
            ]}
          >
            <Input></Input>
          </FormItem>
          <FormItem
            label="Price"
            name="price"
            rules={[
              {
                required: true,
                message: "Price can not be empty",
              },
              {
                type: 'number',
                min: 0,
                message: "Price must be a positive number",
              },
              {
                transform: (value) => Number(value),
                validator: (_, value) => {
                  if (isNaN(value)) {
                    return Promise.reject('Price must be a valid number');
                  }
                  return Promise.resolve();
                },
              }
            ]}
          >
            <Input type="number" min={0} />
          </FormItem>
          <FormItem
            label="Duration"
            name="duration"
            rules={[
              {
                required: true,
                message: "Duration can not be empty",
              },
              {
                type: 'number',
                min: 1,
                message: "Duration must be at least 1 minute",
              },
              {
                transform: (value) => Number(value),
                validator: (_, value) => {
                  if (isNaN(value)) {
                    return Promise.reject('Duration must be a valid number');
                  }
                  return Promise.resolve();
                },
              }
            ]}
          >
            <Input type="number" min={1} />
          </FormItem>
          {/* image */}
          {/* <FormItem
            label="Image"
            name="image"
            // rules={[
            //   {
            //     required: true,
            //     message:"Duration can not be empty"
            //   },
            // ]}
          >
            <Upload
              action="https://660d2bd96ddfa2943b33731c.mockapi.io/api/upload"
              listType="picture-card"
              fileList={fileList}
              onPreview={handlePreview}
              onChange={handleChange}
            >
              {fileList.length >= 8 ? null : uploadButton}
            </Upload>
          </FormItem> */}
        </Form>
      </Modal>
      {/* {previewImage && (
        <Image
          wrapperStyle={{
            display: "none",
          }}
          preview={{
            visible: previewOpen,
            onVisibleChange: (visible) => setPreviewOpen(visible),
            afterOpenChange: (visible) => !visible && setPreviewImage(""),
          }}
          src={previewImage}
        />
      )} */}
    </div>
  );
}

export default ManageServices;
